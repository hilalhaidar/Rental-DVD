public class TransactionDetail {
    private int start_date;
    private int end_date;
//    private Transaction transaction;

    public void getTransactionDetail(Transaction transaction) {
        transaction.downloadReceipt();
    }
}
