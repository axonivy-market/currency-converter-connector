[Ivy]
17D7F8306CB80A4D 9.3.1 #module
>Proto >Proto Collection #zClass
Cr0 CurrencyConverter Big #zClass
Cr0 B #cInfo
Cr0 #process
Cr0 @AnnotationInP-0n ai ai #zField
Cr0 @TextInP .type .type #zField
Cr0 @TextInP .processKind .processKind #zField
Cr0 @TextInP .xml .xml #zField
Cr0 @TextInP .responsibility .responsibility #zField
Cr0 @StartSub f0 '' #zField
Cr0 @EndSub f1 '' #zField
Cr0 @RestClientCall f3 '' #zField
Cr0 @PushWFArc f4 '' #zField
Cr0 @PushWFArc f2 '' #zField
>Proto Cr0 Cr0 CurrencyConverter #zField
Cr0 f0 inParamDecl '<Number FromAmount,app.frankfurter.api.client.CurCodes FromCurrency,app.frankfurter.api.client.CurCodes ToCurrency> param;' #txt
Cr0 f0 inParamTable 'out.FromAmount=param.FromAmount;
out.FromCurrency=param.FromCurrency;
out.ToCurrency=param.ToCurrency;
' #txt
Cr0 f0 outParamDecl '<Number ToAmount> result;' #txt
Cr0 f0 outParamTable 'result.ToAmount=in.ToAmount;
' #txt
Cr0 f0 callSignature convert(Number,app.frankfurter.api.client.CurCodes,app.frankfurter.api.client.CurCodes) #txt
Cr0 f0 @CG|tags CONNECTOR #txt
Cr0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>convert(Number,CurCodes,CurCodes)</name>
    </language>
</elementInfo>
' #txt
Cr0 f0 81 49 30 30 -93 24 #rect
Cr0 f0 res:/webContent/icons/curConverterSmall.png?small #fDecoratorIcon
Cr0 f1 561 49 30 30 0 15 #rect
Cr0 f3 clientId f6097886-ec23-421a-8264-e8782f59723e #txt
Cr0 f3 path /latest #txt
Cr0 f3 queryParams 'amount=in.FromAmount;
from=in.FromCurrency;
to=in.ToCurrency;
' #txt
Cr0 f3 resultType app.frankfurter.api.client.Rate #txt
Cr0 f3 responseMapping 'out.ToAmount=result.rates.get(in.ToCurrency.toString()) as Double;
' #txt
Cr0 f3 clientErrorCode ivy:error:rest:client #txt
Cr0 f3 statusErrorCode ivy:error:rest:client #txt
Cr0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Currency Converter API (CurrencyConverter)</name>
    </language>
</elementInfo>
' #txt
Cr0 f3 200 42 288 44 -136 -7 #rect
Cr0 f3 res:/webContent/icons/curConverterSmall.png #fDecoratorIcon
Cr0 f4 111 64 200 64 #arcP
Cr0 f2 488 64 561 64 #arcP
>Proto Cr0 .type com.axonivy.connector.currency.converter.connector.CurrencyConverterData #txt
>Proto Cr0 .processKind CALLABLE_SUB #txt
>Proto Cr0 0 0 32 24 18 0 #rect
>Proto Cr0 @|BIcon #fIcon
Cr0 f0 mainOut f4 tail #connect
Cr0 f4 head f3 mainIn #connect
Cr0 f3 mainOut f2 tail #connect
Cr0 f2 head f1 mainIn #connect
