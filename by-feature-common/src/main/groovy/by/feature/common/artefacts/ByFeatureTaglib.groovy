package by.feature.common.artefacts

import grails.artefact.Artefact
import grails.gsp.TagLib
import groovy.transform.AnnotationCollector
import groovy.util.logging.Slf4j

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@TagLib
@Slf4j
@AnnotationCollector
@interface ByFeatureTaglib {

}