package d260129_01_CarInterfaceEx.자동차기능구현2;

import d260129_01_CarInterfaceEx.CarFunc;
import d260129_01_CarInterfaceEx.자동차기능구현;

public class 자동차기능구현2 extends 자동차기능구현 implements CarFunc {
    @Override
    public void movehandle() {
        System.out.println("새로운 핸들 조작 구현입니다.");
    }

}
