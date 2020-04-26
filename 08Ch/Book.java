public enum Book
{
    JHTP("Java How to Program", "2012"),
    CHTP("C How to Program", "2007"),
    VBHTP("Visual Basic 2010 How to Program", "2011");

    private final String title;
    private final String copyrightYear;

    Book(String bookTitle, String year)
    {
        title = bookTitle;
        copyrightYear = year;
    }

    public String getTitle()
    {
        return title;
    }

    public String getCopyrightYear()
    {
        return copyrightYear;
    }
}