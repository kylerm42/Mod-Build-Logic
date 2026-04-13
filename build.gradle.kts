plugins {
    `groovy-gradle-plugin`
}

val kotlinVersion = "2.3.20"
val fabricLoomVersion = "1.16-SNAPSHOT"
val neoForgeModdevVersion = "2.0.141"

dependencies {
    implementation("net.fabricmc:fabric-loom:$fabricLoomVersion")
    implementation("net.neoforged.moddev:net.neoforged.moddev.gradle.plugin:$neoForgeModdevVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
}
