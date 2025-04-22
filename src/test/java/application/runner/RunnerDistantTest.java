package application.runner;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

/**
 * Le runner utilisé lors d'un lancement via Jenkinsfile.
 * Prends-les features présentes dans le répertoire 'features/distant'
 * Renvoie un rapport cucumber des tests
 * La commande utilisée pour le lancer est 'mvn test -P distant'
 * @author Yoann DAGAND
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/distant")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "application")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports.html, json:target/cucumber.json")
public class RunnerDistantTest {
}

