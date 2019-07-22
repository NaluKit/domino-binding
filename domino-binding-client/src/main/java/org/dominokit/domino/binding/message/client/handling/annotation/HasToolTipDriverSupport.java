package org.dominokit.domino.binding.message.client.handling.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation marks a visual component and tells the processor
 * IsNaluMessageDriver
 * Diese Annotation kennzeichnet ein Widget in einen View als konfigurierbar,
 * d.h.: in diesem View befinden sich Widgets, die von aussen konfiguriert
 * werden koennen. Ein mit dieser Annotation gekennzeichneter View muss das
 * Interface {@link org.dominokit.domino.binding.message.client.handling.IsMessageDriver} implementieren.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HasToolTipDriverSupport {

}
