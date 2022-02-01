package com.kkj.javatest;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import javax.persistence.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packagesOf = App.class)
public class ArchClassTest {

    /**
     * TODO StudyController는 StudyService와 StudyRepository를 사용할 수 있다.
     * TODO Study* 로 시작하는 클래스는 ..study.. 패키지에 있어야 한다.
     * TODO StudyRepository는 StudyService와 StudyController를 사용할 수 없다.
     */

    @ArchTest
    ArchRule controllerClassRule = classes()
            .that()
            .haveSimpleNameEndingWith("Controller")
            .should()
            .accessClassesThat()
            .haveSimpleNameEndingWith("Service")
            .orShould()
            .accessClassesThat()
            .haveSimpleNameEndingWith("Repository");


    @ArchTest
    ArchRule repositoryClassRule = noClasses()
            .that()
            .haveSimpleNameEndingWith("Repository")
            .should()
            .accessClassesThat()
            .haveSimpleNameEndingWith("Service");

    @ArchTest
    ArchRule studyClassRule = classes()
            .that()
            .haveSimpleNameStartingWith("Study")
            .and()
            .areNotEnums()
            .and().areNotAnnotatedWith(Entity.class)
            .should()
            .resideInAPackage("..study..");
}
