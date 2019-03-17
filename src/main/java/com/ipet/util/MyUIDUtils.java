package com.ipet.util;
 
import java.util.Calendar;
import java.util.UUID;

public class MyUIDUtils {
	private static int SEQ1000 = 0;
	private static int SEQ100=0;
	private static int SEQ10=0;
	private static int SEQ0=0;
	private static int SEQM1 =0;
	private static int SEQM2 =0;
	private static int MILLSEC =0;
	private final static char[] idchars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	private final static int IDLENGTH = idchars.length;
	private final static int IDLENGTH2 = 36;

	static {
		long h = UUID.randomUUID().hashCode();
		long h2 = UUID.randomUUID().hashCode();
		//System.out.println(h + "=====" + h2);
		if (h<0) h= 0-h;
		SEQ0 = (int) (h%IDLENGTH2);
		h=h/IDLENGTH2;
		SEQ10 = (int) (h%IDLENGTH);
		h=h/IDLENGTH;
		SEQ100 = (int) (h%IDLENGTH);
		h=h/IDLENGTH;
		SEQ1000 = (int) (h%IDLENGTH);
	    if (SEQ0>1) SEQ0--;	
		long hh=System.currentTimeMillis();
		MILLSEC = (int)(hh%999 + h2 % 777 + h % 333)%555;
		
		hh= hh%1000;   //get Millseconds 999ms
		hh= hh+ h2 %100;
		if (hh<0) hh= 0-hh;
		SEQM1 = (int) (hh%IDLENGTH);
		SEQM2 = (int) (hh/IDLENGTH%IDLENGTH);
	}
	
    private static void getSEQ() {
    	SEQ0++;
    	if (SEQ0>=IDLENGTH2) {
    		SEQ10 ++;
    		SEQ0=0;
    		SEQM1++ ;
    	}
    	if (SEQ10>=IDLENGTH) {
    		SEQ100++;
    		SEQ10=0;
    		SEQM2++;
    	}
    	if (SEQM1>=IDLENGTH) {
    		SEQM2++;
    		SEQM1=0;
    	}
    	if (SEQM2>=IDLENGTH) {
    		SEQM2=0;
    	}
    	
    	if (SEQ100>=IDLENGTH) {
    		SEQ1000++;
    		SEQ100=0;
    	}
    	if (SEQ1000>=IDLENGTH) {
    		SEQ1000=0;
    	}
    }

    public static String getId10() {
    	StringBuffer buf = new StringBuffer();
		Calendar cal=Calendar.getInstance();
		//Date date = new Date();
		//cal.setTime(date);
		buf.append(idchars[cal.get(Calendar.YEAR)%100%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.MONTH)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.DAY_OF_MONTH)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.HOUR_OF_DAY)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.MINUTE)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.SECOND)%IDLENGTH]);
		buf.append(idchars[SEQM2]);
		buf.append(idchars[SEQM1]);
		buf.append(idchars[SEQ10]);
		buf.append(idchars[SEQ0]);
    	getSEQ();
    	return buf.toString();
    }

    public static String getFID10() {
    	StringBuffer buf = new StringBuffer();
		Calendar cal=Calendar.getInstance();
		//Date date = new Date();
		//cal.setTime(date);
		buf.append(idchars[cal.get(Calendar.YEAR)%100%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.MONTH)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.DAY_OF_MONTH)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.HOUR_OF_DAY)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.MINUTE)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.SECOND)%IDLENGTH]);
		MILLSEC = MILLSEC+1;
		MILLSEC = MILLSEC % 999;
		String s = "" + MILLSEC;
		if (s.length()<3) s = "0" + s;
		if (s.length()<3) s = "0" + s;
		if (s.length()<3) s = "0" + s;
		buf.append(s);
    	return buf.toString();
    }
    public static String getId12() {
    	StringBuffer buf = new StringBuffer();
		Calendar cal=Calendar.getInstance();
		//Date date = new Date();
		//cal.setTime(date);
		buf.append(idchars[cal.get(Calendar.YEAR)%100%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.MONTH)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.DAY_OF_MONTH)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.HOUR_OF_DAY)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.MINUTE)%IDLENGTH]);
		buf.append(idchars[cal.get(Calendar.SECOND)%IDLENGTH]);
		buf.append(idchars[SEQM2]);
		buf.append(idchars[SEQM1]);
		buf.append(idchars[SEQ1000]);
		buf.append(idchars[SEQ100]);
		buf.append(idchars[SEQ10]);
		buf.append(idchars[SEQ0]);
    	getSEQ();
    	//System.err.println(buf.toString());
    	return buf.toString();
    }
    
	public static void main(String[] args) {

		System.out.println("===========================");
		for (int i = 1; i < 10; i++) {
	
			String s = getId10();
			System.out.println(s);
		}
	}
}
