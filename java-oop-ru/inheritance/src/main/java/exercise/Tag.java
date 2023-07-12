package exercise;

import jdk.jshell.spi.SPIResolutionException;
import org.w3c.dom.ls.LSOutput;

import java.util.stream.Collectors;
import java.util.Map;


public abstract class Tag {

    protected String tag;
    protected Map<String, String> atrs;


    public Tag(String tag, Map<String, String> atrs) {
        this.tag = tag;
        this.atrs = atrs;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setAtrs(Map<String, String> atrs) {
        this.atrs = atrs;
    }

    public String getTag() {
        return tag;
    }

    public Map<String, String> getAtrs() {
        return atrs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(tag);

        for(Map.Entry<String, String> entry : atrs.entrySet()) {
            String atrsName = entry.getKey();
            String atrsValue = entry.getValue();
            sb.append(" ").append(atrsName).append("=\"").append(atrsValue).append("\"");
        }

        sb.append(">");
        return sb.toString();
    }
}
