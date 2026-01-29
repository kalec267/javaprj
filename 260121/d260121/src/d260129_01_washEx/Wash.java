package d260129_01_washEx;

/*��Ź���� ��� ����
����(startButton)
����(stopButton)
����(pauseButton)
�ӵ� ����(changeButton) : �ӵ� ������ ���� �Է��ϸ� �ش� ������ �ӵ��� ����
�߰������� �ӵ� ���� 10~100������ ���� �� �� �����ϵ��� ����
*/
public interface Wash {
    public void startButton();

    public void stopButton();

    public void pauseButton();

    public void changeButton(int speed);

    default void dry(){

    };
    default void clean(){

    };

}
