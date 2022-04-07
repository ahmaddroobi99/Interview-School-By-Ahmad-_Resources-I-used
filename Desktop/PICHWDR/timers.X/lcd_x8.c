
#include "lcd_x8.h"

//unsigned char  LCD_INIT_STRING[4] = {(unsigned char)(0x20 |((unsigned char)LCD_TYPE << 2)), (unsigned char)0xc,(unsigned char)1, (unsigned char)6};

unsigned char LCD_INIT_STRING[4] = {0x20 | (LCD_TYPE << 2), 0xc, 1, 6};
//unsigned char  LCD_INIT_STRING[4] = {0x28, 0xc, 1, 6};

//#define lcd_output_enable(x) lcd.enable =x;
//#define lcd_output_rs(x) lcd.rs =x
/*
void delay_ms(unsigned int n) {
    int x;
    for (x = 0; x <= n; x++) {
        __delaywdt_ms(1);
        // __delay_ms(1);   // 20x10 200ms
    }
}
*/
void delay_cycles(unsigned char n) {
    int x;
    for (x = 0; x <= n; x++) {
        CLRWDT(); //NOP();   // 20x10 200ms
    }

}
//void delay_us ()

void lcd_send_nibble(unsigned char n) {

    lcd.data = n;

    delay_cycles(1); //here 1111
    lcd_output_enable(1);
    __delaywdt_us(2); //delay_us(2);//20
    lcd_output_enable(0);
}

void lcd_send_byte(unsigned char cm_data, unsigned char n) {

    //  lcd_output_rs(0);
    //  delay_ms(1);     ////while ( bit_test(lcd_read_byte(),7) ) ;
    lcd_output_rs(cm_data);
    delay_cycles(1);
    // lcd_output_rw(0);
    delay_cycles(1);
    lcd_output_enable(0);
    lcd_send_nibble(n >> 4);
    lcd_send_nibble(n & 0x0f);
    if (cm_data) __delaywdt_us(200);
  
        //delay_ms(2); //added by raed
    // lcd_output_rs(0);//added 
}

void lcd_init(void) {

    unsigned char i;


    lcd_output_rs(0);
    //lcd_output_rw(0); 
    lcd_output_enable(0);

    delay_ms(25); //   
    for (i = 1; i <= 3; ++i) {
        lcd_send_nibble(3);
        // lcd_send_nibble(0);
      //  delay_ms(6); //5
    }

    lcd_send_nibble(2);
    //  lcd_send_nibble(0);
    for (i = 0; i <= 3; ++i)
        lcd_send_byte(0, LCD_INIT_STRING[i]);
}

/*void lcd_gotoxy(unsigned char x, unsigned char y) {
    unsigned char address;

    if (y != 1)
        address = LCD_LINE_TWO;
    else
        address = 0;
    address += x - 1;
    lcd_send_byte(0, (unsigned char) (0x80 | address));
}
 */
void lcd_gotoxy(unsigned char x, unsigned char y) {
    unsigned char address;

    switch (y) {
        case 1: address = 0x80;
            break;
        case 2: address = 0xc0;
            break;
        case 3: address = 0x80 + LCD_LINE_SIZE;
            break;
        case 4: address = 0xc0 + LCD_LINE_SIZE;
            break;
    }
    address += x - 1;
    lcd_send_byte(0, (unsigned char) (0x80 | address));
}

void lcd_putc(char c) {
    switch (c) {
        case '\f': lcd_send_byte(0, 1);
            delay_ms(2);
            break;
        case '\n': lcd_gotoxy(1, 2);
            break;
        case '\b': lcd_send_byte(0, 0x10);
            break;
        default: lcd_send_byte(1, c);
            break;
    }
}

void lcd_puts(char *s) {
    while (*s) {
        lcd_putc(*s);
        s++;
    }
}

void Lcd_Shift_Right(void) {

    lcd_send_byte(0, 0x1C);
    //Lcd_Cmd(0x01);
    //Lcd_Cmd(0x0C);
}

void Lcd_Shift_Left(void) {
    lcd_send_byte(0, 0x18);
    //Lcd_Cmd(0x01);
    //Lcd_Cmd(0x08);
}