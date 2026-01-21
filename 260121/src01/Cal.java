class Cal {
    public static void main(String[] args) {

        // 실행 인자 개수 검사 (런타임 오류 방지)
        if (args.length < 2) {
            System.out.println("두 개의 숫자를 입력하세요.");
            return;
        }

        // 문자열 결합
        System.out.println(args[0] + args[1]);

        // 문자열 → 정수 변환
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        // 정수 덧셈
        System.out.println(a + b);

        // static 메서드 호출 (객체 생성 불필요)
        System.out.println(MyData.hund());
    }
}
