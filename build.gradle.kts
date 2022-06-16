import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
    id("org.jetbrains.compose") version "1.0.0-alpha3"
}

group = "de.amirrocker"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

// TODO clean up build.gradle!
dependencies {
    testImplementation(kotlin("test"))
    implementation(compose.desktop.currentOs)

    // rx?
    implementation("io.reactivex.rxjava3:rxjava:3.1.3")
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")

    // serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test:1.6.0")
    testImplementation("org.amshove.kluent:kluent:1.68")

    // look here for resources:
    // https://github.com/JetBrains/KotlinDL
    // kotlin DL & ONNX (open neural network exchange format)
    implementation("org.jetbrains.kotlinx:kotlin-deeplearning-api:0.3.0")
    implementation("org.jetbrains.kotlinx:kotlin-deeplearning-onnx:0.3.0")
    implementation("org.jetbrains.kotlinx:kotlin-deeplearning-visualization:0.3.0")
    // separate dependency for onnx extensions for kotlin
    implementation("org.jetbrains.kotlinx:kotlin-deeplearning-onnx:0.3.0")

    // GPU support for tensor calculation (nvidia only)
    api("org.tensorflow:libtensorflow:1.15.0")
    api("org.tensorflow:libtensorflow_jni_gpu:1.15.0")

    val koin_version = "3.1.5"
    // Koin Core features
    implementation("io.insert-koin:koin-core:$koin_version")
// Koin Test features
    testImplementation("io.insert-koin:koin-test:$koin_version")


}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KotlinDLMeetsComposeDesktop"
            packageVersion = "1.0.0"
        }
    }
}