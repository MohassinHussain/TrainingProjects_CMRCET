package LibraryManagementPackage;

class Member {
    private String memberName, memberId;
    public Member(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }
    public String getMemberName() {
        return memberName;
    }
    public String getMemberId() {
        return memberId;
    }
    public void borrowBook(Book book) {
        System.out.println("Borrowed book: " + book.getTitle());
    }
    public void returnBook(Book book) {
        System.out.println("Returned book: " + book.getTitle());
    }
}
