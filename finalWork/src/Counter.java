class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void add() throws Exception {
        if (count == 0) {
            throw new Exception("Счетчик не был использован в инструкции try-with-resources или ресурс не был закрыт");
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        if (count > 0) {
            System.out.println("Счётчик закрыт");
            count = 0;
        }
    }
}