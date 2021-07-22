package com.mobiquity.atmlocator.exception;

public class AtmNotFoundException  extends Exception{

    private static final long serialVersionUID = -3841677326659278730L;

    public AtmNotFoundException() {
        super();
    }

    public AtmNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public AtmNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public AtmNotFoundException(String arg0) {
        super(arg0);
    }

    public AtmNotFoundException(Throwable arg0) {
        super(arg0);
    }
}
