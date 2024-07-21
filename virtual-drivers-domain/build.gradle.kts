dependencies {
    implementation(project(":virtual-drivers-common"))
    implementation(project(":virtual-drivers-infrastructure:jpa"))
    implementation(project(":virtual-drivers-infrastructure:client"))
}

val testJar by tasks.registering(Jar::class) {
    archiveBaseName.set("test-${archiveBaseName.get()}")
    from(sourceSets.test.get().output)
    println(sourceSets.test.get().output)
}

configurations {
    create("testJarConfig")
}

testJar.get().dependsOn(tasks.testClasses)

artifacts {
    add("testJarConfig", testJar)
}
