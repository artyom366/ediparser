### Edifact Punctuation
* Apostrophe ’ = segment terminator
    > UNH+1_7118460+INSDES:D:96A:UN:EAN001'
* Plus sign + = segment tag and data element separator
    > NAD+BY+4311560000000
* Colon : = component data element separator
    > INSDES:D:96A:UN
* Question mark ? = release character. Immediately preceding any of the special characters ’+:?
the release character returns it to its normal meaning. For example,
10?+10=20 means 10+10=20. Question mark is represented by ?? A
release character is not counted when calculating the maximum length of the
data element in which it occurs.
    > anm?: 02225-803190
* Period . = decimal point. The period does not require a release character when it occurs
as a normal text punctuation mark
    > telef. anm?: 02225-803190
*** 
### To Do
* Interchange (multiple document type in one message, to enquire)
* Document to multiple object binding (custom binding implementation possible, to be tested)
* Custom interchange binding implementation(to be tested)  
* Data consistency (custom fields, if there are any, may or may not be mapped to object, to be tested)
***
### Issues
##### INSDES 96a (first revision was in 98a, standard violation)
* It is not possible to bind this type of document using standard framework solution
    * find out the document type and version before processing and use the 98AInterchange class (custom binding implementation might be used)
    and then change document version from 96a to 98a
    * add INSDES type into 96AInterchange class

##### New line feeds & Carriage returns (codes: 10 & 13) in some of the documents violating the standards
* IGNORE NEW LINES setting is not working or partially implemented (i.e in xml parser)
    * process the document before java object binding
    * fix the issue in framework
***



