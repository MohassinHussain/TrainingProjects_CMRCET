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
        System.out.println(memberName + " borrowed " + book.getTitle());
    }

    public void returnBook(Book book) {
        System.out.println(memberName + " returned " + book.getTitle());
    }
}
