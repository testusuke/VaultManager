plugins {
    id ("org.jetbrains.kotlin.jvm") version "1.3.72"
    id ("net.minecrell.plugin-yml.bukkit") version "0.3.0"
}

group = "net.testusuke.manager"
version = "1.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
    //  Vault
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation("com.destroystokyo.paper:paper-api:1.15.2-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    //  Vault
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
}

tasks{
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

bukkit {
    name = project.name
    version = project.version.toString()
    main = "$group.vault.Main"
    author = "testusuke"
    apiVersion = "1.15"
}

val jar by tasks.getting(Jar::class) {
    from(configurations.compile.get().map {
        if (it.isDirectory) it else zipTree(it)
    })
}

val sourceJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allJava.srcDirs)
}