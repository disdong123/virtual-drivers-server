dependencies {
    implementation(project(":template-domain"))
    implementation(project(":template-common"))
    implementation(libs.spring.boot.starter.web)

    testImplementation(project(path = ":template-domain", configuration = "testJarConfig"))
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
