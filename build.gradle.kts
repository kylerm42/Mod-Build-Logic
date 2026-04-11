plugins {
    `groovy-gradle-plugin`
}

val kotlinVersion = "2.0.21"
val fabricLoomVersion = "1.9-SNAPSHOT"
val neoForgeModdevVersion = "0.1.110"

dependencies {
    implementation("net.fabricmc:fabric-loom:$fabricLoomVersion")
    implementation("net.neoforged.moddev:net.neoforged.moddev.gradle.plugin:$neoForgeModdevVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
}
