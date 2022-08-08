package github.racolin.dagger.dagger.basic;

public class Third {
    private Integer value;
    private String key;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private Third() {}
    static class Builder {
        private Third third;
        public Builder() {
            third = new Third();
        }
        public Third build() {
            return third;
        }
        public Builder addKey(String key) {
            third.key = key;
            return this;
        }
        public Builder addValue(Integer value) {
            third.value = value;
            return this;
        }
    }
}
