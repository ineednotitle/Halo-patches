# Zero-local-setup build: let the CI produce your `.mpp`

Everything happens on github.com. No JDK, no Gradle, no tokens to create.

## 1. Create the repo
1. Log in to github.com → **+** (top right) → **New repository**.
2. Name it e.g. `doom-reddit-patches`. **Public** is recommended
   (workflows run free on public repos; private repos burn Actions minutes).
   Do NOT add a README/.gitignore (keep it empty).
3. Create repository.

## 2. Upload the code
1. Extract `doom-reddit-patches.zip` on your computer.
2. In the empty repo page, click **uploading an existing file**.
3. Drag the **contents** of the extracted folder into the upload area
   (all ~25 files incl. `.github/`, `patches/`, `extensions/`, `gradle/`).
4. **Commit message matters** — semantic-release only releases on
   conventional commits. Use exactly:
   `feat: add Reddit patches for 2026.42.0`
5. Commit directly to `main`.

## 3. Point the bundle metadata at your repo
Edit `patches/build.gradle.kts` (pencil icon in the GitHub UI) and replace
all four `YOUR_USERNAME` placeholders with your GitHub username. Commit
message: `chore: set bundle owner`. (A `chore:` commit intentionally does
NOT release by itself.)

## 4. Enable workflow permissions (one-time, 30 seconds)
Repo → **Settings → Actions → General**:
- **Workflow permissions** → enable "Allow GitHub Actions to create and
  approve pull requests" (needed for the dev→main auto-PR flow).
- Leave "Read and write permissions"? If present, choose **Read and write**
  so semantic-release can push the changelog back to main.

## 5. Run / let it release
The `Release` workflow fires automatically on the `feat:` push to main.
To force it manually: **Actions → Release → Run workflow → Run workflow**
(branch: main).

Watch the run: `npm install` → semantic-release → `./gradlew generatePatchesList`
(the Gradle daemon builds the Android extension + Kotlin patches; the runner's
built-in `GITHUB_TOKEN` authenticates against the Morphe Packages registry —
that is the key that is impossible without CI or a local PAT).

Expect ~3–8 minutes.

## 6. Get your .mpp
Repo → **Releases** → **v1.0.0** → Assets:
- `patches-1.0.0.mpp` ← **the file you asked for**
- `patches-1.0.0.mpp.asc`, `patches-bundle.json`, `patches-list.json`, `SHA256SUMS.txt`

## 7. Use it
- **Morphe Desktop**: drag in `patches-1.0.0.mpp` + your Reddit 2026.42.0
  APKM → select "Remove ads" + "Unlock Premium" → Patch.
- **Morphe Manager (Android)**: Settings → Expert mode ON → Patch bundles → `+`
  → add local file = the `.mpp`. Or add the permanent remote source:
  `https://github.com/<you>/doom-reddit-patches` (reads `patches-bundle.json`
  from the latest release, auto-updates on every release).

## If the workflow fails
| Symptom | Fix |
|---|---|
| "No release published", only "Verify project compiles" ran | Your commit message lacked `feat:`/`fix:`. Push an empty commit: `feat: trigger release` |
| `401` from maven.pkg.github.com | Should not happen in CI (GITHUB_TOKEN is automatic). If it does, add a repo secret `GH_REGISTRY_TOKEN` = a PAT with read:packages and extend the workflow env (unlikely needed) |
| `Release` step fails on npm | Re-run the job once (npm registry flake) |
| Patch fails on a NEW Reddit build | Run the re-verify steps in `Fingerprints.kt` headers, fix filters, commit as `fix: reddit <version>` → new release auto-builds |
