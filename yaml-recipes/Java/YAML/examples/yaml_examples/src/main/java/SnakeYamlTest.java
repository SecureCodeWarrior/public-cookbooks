import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.BaseConstructor;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

public class SnakeYamlTest {
    Yaml yaml = new Yaml();

    Yaml yaml2 = new Yaml(new Constructor());
    Yaml yaml3 = new Yaml(new Representer());
    Yaml yaml4 = new Yaml(new BaseConstructor() {}, new Representer());
    Yaml yaml5 = new Yaml(new Constructor(), new Representer());
    Yaml yaml6 = new Yaml(new BaseConstructor() {});
}

