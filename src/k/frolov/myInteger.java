package k.frolov;

/**
 * Created by Konstantin on 07.09.2016.
 */
public class myInteger extends Primary {
    private long value;

    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public long Calculate(){
        return value;
    }

    @Override public String ToJSON(){
        return "" + value;
    }
}
