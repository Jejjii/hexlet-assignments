package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class PairedTag extends Tag {

    public String body;
    public List<Tag> childs;

    public PairedTag(String tag, Map<String,String> atrs,String body,List<Tag> childs) {
        super(tag, atrs);
        this.body =body;
        this.childs =childs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());

        if (!body.isEmpty()) {
            sb.append(body);
        }

        for(Tag child: childs) {
            sb.append(child.toString());
        }
        sb.append("</").append(tag).append(">");
        return sb.toString();
    }


}
