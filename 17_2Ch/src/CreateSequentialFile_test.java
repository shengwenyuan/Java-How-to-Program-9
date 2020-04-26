public class CreateSequentialFile_test
{
    public static void main(String[] args) {
        CreateSequentialFile application = new CreateSequentialFile();

        application.openFile();
        application.addRecords();
        application.closeFile();
    }
}
