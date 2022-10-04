package com.kou.tank.enume;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 坦克 枚举
 */
@AllArgsConstructor
@Getter
public enum TankEnum {

    SIZE_X(50,"宽50"),
    SIZE_Y(50,"高50");

    private int size;
    private String msg;


}
