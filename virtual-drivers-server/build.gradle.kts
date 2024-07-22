dependencies {
    implementation(project(":virtual-drivers-domain"))
    implementation(project(":virtual-drivers-common"))
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.thymeleaf)

    testImplementation(project(path = ":virtual-drivers-domain", configuration = "testJarConfig"))
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
