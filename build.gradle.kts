plugins {
    `groovy-gradle-plugin`
}

val kotlinVersion = "2.4.21"
val fabricLoomVersion = "1.19.3"
val neoForgeModdevVersion = "2.0.148"

dependencies {
    implementation("net.fabricmc.fabric-loom:net.fabricmc.fabric-loom.gradle.plugin:$fabricLoomVersion")
    implementation("net.neoforged.moddev:net.neoforged.moddev.gradle.plugin:$neoForgeModdevVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
}
