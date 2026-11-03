# Mod-Build-Logic (kylerm42 fork, `26.3` branch)

Shared Gradle convention plugins and platform versions for Percale, Kambrik and Bountiful. This branch targets
Minecraft 26.3 (unobfuscated, no mappings) on Fabric and NeoForge. Only Fabric is validated.

## `platform.properties`

`platform.properties` is the single place to bump the Minecraft and loader versions: `minecraft_version`,
`java_version`, `fabric_version`, `fabric_loader_version`, `fabric_language_kotlin_version`, `neo_form_version`,
`neoforge_version`, `forgelike_adapter_version`, `mixin_version`, `mixin_extras_version`,
`kotlinx_serialization_version` and `mod_menu_version`. The `multiloader-settings` settings plugin loads the file
and exposes every key as a project property in the consuming build, unless that project already defines it.

Plugin versions (Fabric Loom, NeoForge ModDev, Kotlin) are not in `platform.properties`. They are set in
`build.gradle.kts`. Loom 1.19.x needs Gradle 9.8 or newer, so the consumers' wrappers must match.

## Sibling checkout

The consuming repositories include this build with `includeBuild('../build-logic')`. Check it out next to them:

```
minecraft/
├── build-logic/   (this repository, branch 26.3)
├── Percale/
├── Kambrik/
└── Bountiful/
```

`multiloader-settings` looks for `platform.properties` in `<root>/build-logic/` (submodule layout) and then in
`<root>/../build-logic/` (sibling layout). It fails with a `GradleException` if neither exists. The `26.x` branch
holds the 26.1.2 values, so the build-logic branch must match the branch of the consuming repositories.

## Plugins

| Plugin id | Purpose |
|---|---|
| `multiloader-settings` | Settings plugin. Loads `platform.properties`. |
| `multiloader-root` | Root project: Kotlin JVM and serialization plugins for all subprojects. |
| `multiloader-common` | Shared project conventions: Java toolchain, repositories, versioning, publishing, resource expansion. |
| `multiloader-common-module` | The `:common` module (Minecraft sources through NeoForm). |
| `multiloader-loader` | Shared conventions for loader modules (consume `:common` sources and resources). |
| `multiloader-fabric` | The `:fabric` module: no-remap Loom, Fabric API, Fabric Language Kotlin, run configurations. |
| `multiloader-neoforge` | The `:neoforge` module: ModDev 2. |

## Client source set

Loom's `splitEnvironmentSourceSets()` is not used. `multiloader-fabric` adds `src/client/java` and
`src/client/resources` of a Fabric module to the main source set, so client entrypoints declared in
`fabric.mod.json` are compiled and packaged in the mod jar. The shared `:common` sources are compiled into the
Fabric module's main source set and reference `net.minecraft.client.*`, which a split (server-side) main source set
cannot see. Client classes are loaded only through the `client` entrypoint, so dedicated servers are unaffected.
