package slotmachineTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SlotMachine.*;


public class slotImageTests {

    public Slot slot;

    @BeforeEach
    public void SetUp() {
        slot = new Slot(0, 0);
    }

    @Test
    public void check_setSlotImage() {

        //given
        String iconName = "banana";

        //when
        slot.setSlotImage(iconName);
        String result = slot.getSlotName();

        //then
        assertEquals(iconName, result);

    }


}
