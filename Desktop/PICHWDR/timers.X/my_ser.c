#include "my_ser.h"

void setupSerial(void) {
    unsigned char dummy;
    BAUDCONbits.BRG16 = 0;
    TXSTA = 0;
    SPBRG = 25;
    SPBRGH = 0;
    TXSTAbits.BRGH = 1; //baud rate high speed option
    TXSTAbits.TXEN = 1; //	;enable transmission

    RCSTA = 0; // ;SERIAL RECEPTION W/ 8 BITS,,
    RCSTAbits.CREN = 1; //;enable reception
    RCSTAbits.SPEN = 1;
    ; //enable serial port
    dummy = RCREG; //, W        ; clear the receiver buffer      
    dummy = RCREG; //,W         ; clear the receiver buffer
    return;
}

unsigned char read_byte_no_lib(void) {
    unsigned char c;

    if (RCSTAbits.FERR || RCSTAbits.OERR)//check for error
    {
        RCSTAbits.CREN = 0;
        RCSTAbits.CREN = 1;
    }
    // wait until byte available
    while (!(PIR1bits.RCIF)) {
        CLRWDT(); //if enabled
    }
    c = RCREG;
    return c;
}

void send_byte_no_lib(unsigned char c) {
    while (!TXSTAbits.TRMT)//fixed 
    {
        CLRWDT(); //if enabled  
    }
    TXREG = c;
}

void send_string_no_lib(unsigned char *p) {
    while (*p) {
        send_byte_no_lib(*p); //or use the send_byte_no_lib()
        p++;
    }
}