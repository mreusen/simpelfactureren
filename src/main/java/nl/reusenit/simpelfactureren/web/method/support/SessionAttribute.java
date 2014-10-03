package nl.reusenit.simpelfactureren.web.method.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;

/**
 * @author ReusenIT
 *
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SessionAttribute {

	/**
	 * The name of the session attribute to bind to
	 */
	String value() default "";
	
	/**
	 * Whether the parameter is required
	 */
	boolean required() default true;
	
	/**
	 * Whether attribute needs to be exposed as model attribute
	 */
	boolean exposeAsModelAttribute() default false;
}
