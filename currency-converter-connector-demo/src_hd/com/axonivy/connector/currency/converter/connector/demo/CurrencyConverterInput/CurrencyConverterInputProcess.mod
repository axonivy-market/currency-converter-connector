[Ivy]
17801C4C33DC6518 9.3.1 #module
>Proto >Proto Collection #zClass
Cs0 CurrencyConverterInputProcess Big #zClass
Cs0 RD #cInfo
Cs0 #process
Cs0 @AnnotationInP-0n ai ai #zField
Cs0 @TextInP .type .type #zField
Cs0 @TextInP .processKind .processKind #zField
Cs0 @TextInP .xml .xml #zField
Cs0 @TextInP .responsibility .responsibility #zField
Cs0 @UdInit f0 '' #zField
Cs0 @UdProcessEnd f1 '' #zField
Cs0 @PushWFArc f2 '' #zField
Cs0 @UdEvent f3 '' #zField
Cs0 @UdExitEnd f4 '' #zField
Cs0 @PushWFArc f5 '' #zField
Cs0 @UdEvent f6 '' #zField
Cs0 @CallSub f8 '' #zField
Cs0 @PushWFArc f10 '' #zField
Cs0 @PushWFArc f11 '' #zField
>Proto Cs0 Cs0 CurrencyConverterInputProcess #zField
Cs0 f0 guid 17801C4C34134211 #txt
Cs0 f0 method start() #txt
Cs0 f0 inParameterDecl '<> param;' #txt
Cs0 f0 outParameterDecl '<> result;' #txt
Cs0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
Cs0 f0 83 51 26 26 -17 27 #rect
Cs0 f1 595 51 26 26 0 12 #rect
Cs0 f2 109 64 595 64 #arcP
Cs0 f3 guid 17801C4C34CDE414 #txt
Cs0 f3 actionTable 'out=in;
' #txt
Cs0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>close</name>
    </language>
</elementInfo>
' #txt
Cs0 f3 83 267 26 26 -15 15 #rect
Cs0 f4 595 267 26 26 0 12 #rect
Cs0 f5 109 280 595 280 #arcP
Cs0 f6 guid 17801C80C219DBBE #txt
Cs0 f6 actionTable 'out=in;
' #txt
Cs0 f6 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>calculate</name>
    </language>
</elementInfo>
' #txt
Cs0 f6 83 179 26 26 -15 15 #rect
Cs0 f8 processCall CurrencyConverter:convert(Number,app.frankfurter.api.client.CurCodes,app.frankfurter.api.client.CurCodes) #txt
Cs0 f8 requestActionDecl '<Number FromAmount,app.frankfurter.api.client.CurCodes FromCurrency,app.frankfurter.api.client.CurCodes ToCurrency> param;' #txt
Cs0 f8 requestMappingAction 'param.FromAmount=in.convert.FromAmount;
param.FromCurrency=in.convert.FromCurrency;
param.ToCurrency=in.convert.ToCurrency;
' #txt
Cs0 f8 responseMappingAction 'out=in;
out.convert.ToAmount=result.ToAmount;
' #txt
Cs0 f8 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>CurrencyConverter</name>
    </language>
</elementInfo>
' #txt
Cs0 f8 232 170 128 44 -58 -7 #rect
Cs0 f10 109 192 232 192 #arcP
Cs0 f11 360 192 608 77 #arcP
Cs0 f11 1 608 192 #addKink
Cs0 f11 0 0.7484365262049805 0 0 #arcLabel
>Proto Cs0 .type com.axonivy.connector.currency.converter.connector.demo.CurrencyConverterInput.CurrencyConverterInputData #txt
>Proto Cs0 .processKind HTML_DIALOG #txt
>Proto Cs0 -8 -8 16 16 16 26 #rect
Cs0 f0 mainOut f2 tail #connect
Cs0 f2 head f1 mainIn #connect
Cs0 f3 mainOut f5 tail #connect
Cs0 f5 head f4 mainIn #connect
Cs0 f6 mainOut f10 tail #connect
Cs0 f10 head f8 mainIn #connect
Cs0 f8 mainOut f11 tail #connect
Cs0 f11 head f1 mainIn #connect
