import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.plugins.AppPlugin
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project


/**
 * @author Leo.ZhangTJ
 * @time 2020/6/1
 * @function
 * @describe
 */
class TestPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        if (!project.plugins.hasPlugin(AppPlugin::class.java)) {
            throw GradleException("this plugin is not application")
        }

        val android = project.extensions.getByType(AppExtension::class.java)
        val testTransform = TestTransform();
        android.registerTransform(testTransform)
    }

}