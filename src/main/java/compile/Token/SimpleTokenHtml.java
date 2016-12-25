package compile;

/**
 * Created by wangqi on 2016/12/14.
 */
public class SimpleTokenHtml implements SimpleToken, WordBean {
    private int type = HTML;
    private String html;

    public SimpleTokenHtml(String html) {
        this.html = html;
    }

    public String getHtml() {
        return html;
    }
    public void append(String addtion){
        StringBuilder sb = new StringBuilder(html);
        sb.append(addtion);
        html = sb.toString();
    }
    @Override
    public int getType() {
        return type;
    }

}
