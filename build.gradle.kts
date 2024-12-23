plugins {
    id("java")
    id("fabric-loom") version "1.9-SNAPSHOT"
    id("xyz.jpenilla.resource-factory-fabric-convention") version "1.2.0"
}

group = "kr.toxicity.hud.example.fabric"
version = "1.0"

repositories {
    mavenCentral()
}

val minecraft = properties["minecraft_version"]

dependencies {
    minecraft("com.mojang:minecraft:$minecraft")
    mappings("net.fabricmc:yarn:${properties["yarn_mappings"]}:v2")
    modImplementation("net.fabricmc:fabric-loader:${properties["loader_version"]}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${properties["fabric_version"]}")

    //BetterHud API
    compileOnly("io.github.toxicity188:BetterHud-standard-api:1.11.1")
    modCompileOnly("io.github.toxicity188:BetterHud-fabric-api:1.11.1")

    //BetterHud Library
    compileOnly("io.github.toxicity188:BetterCommand:1.4.1")
    modCompileOnly("net.kyori:adventure-platform-mod-shared-fabric-repack:${properties["kyori_mod_implementation"]}")
    modCompileOnly("net.kyori:adventure-platform-fabric:${properties["kyori_mod_implementation"]}")

    //Lombok
    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")

    testCompileOnly("org.projectlombok:lombok:1.18.36")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.36")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks {
    test {
        useJUnitPlatform()
    }
    compileJava {
        options.encoding = Charsets.UTF_8.name()
    }
}

fabricModJson {
    id = rootProject.name
    name = rootProject.name
    version = project.version.toString()
    description = "BetterHud fabric api test mod."
    authors.set(listOf(person("toxicity") {
        contact.sources = "https://github.com/toxicity188/betterhud-fabric-example"
    }))
    license = listOf("MIT")
    entrypoints = listOf(
        mainEntrypoint("kr.toxicity.hud.example.fabric.Main"),
    )
    depends = mapOf(
        "fabricloader" to listOf("*"),
        "minecraft" to listOf("~$minecraft"),
        "java" to listOf(">=21"),
        "fabric-api" to listOf("*"),
        "betterhud" to listOf("*")
    )
}
