package Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Sniper on 2018/4/16.
 */
public class Data implements Serializable, Comparable {
    final static int TWELVEHOURS = 1;
    final static int ONEDAY = 2;
    final static int TWODAYS = 3;
    final static int FOURDAYS = 4;
    final static int SEVENDAYS = 5;
    final static int FIFTEENDAYS = 6;
    final static int MORE = 7;
    final static int NEVER = 0;

    private String id;
    private String mainName;
    private String indexName;
    private LocalDate nextTime;
    private int state = TWELVEHOURS;
    private boolean finish = false;

    public Data(String id) {
        this.id = id;
    }

    public Data(String id, String mainName, String indexName, LocalDate nextTime) {
        this.id = id;
        this.mainName = mainName;
        this.indexName = indexName;
        this.nextTime = nextTime;
    }

    public Data(String id, String mainName, String indexName, LocalDate nextTime, int state) {
        this.id = id;
        this.mainName = mainName;
        this.indexName = indexName;
        this.nextTime = nextTime;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public LocalDate getNextTime() {
        return nextTime;
    }

    public void setNextTime(LocalDate nextTime) {
        this.nextTime = nextTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        return id != null ? id.equals(data.id) : data.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", mainName='" + mainName + '\'' +
                ", indexName='" + indexName + '\'' +
                ", nextTime=" + nextTime +
                ", state=" + state +
                ", finish=" + finish +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Data data1 = (Data) o;
        if (id.equals(data1.getId())) {
            return 0;
        } else if (Integer.parseInt(id) > Integer.parseInt(data1.getId())) {
            return 1;
        } else {
            return -1;
        }
    }
}
