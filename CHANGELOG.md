# OSGL Tool CHANGELOG

1.4.4
* Check if string is empty or null on `S.startsWith()` and `S.endsWith()` methods #38

1.4.3
* Improve maven build process #37
* Wrong logic in $.anyNull implementation #36

1.4.2
* Add Header style to `Keyword` #35 

1.4.1
* $.invokeMethod shall handle `InvocationTargetException` properly #30 

1.4.0
* Add alias to Osgl Tuple types #25 
* Add more getter method to Osgl tuple types #24 
* Add fast split APIs in `S` util #23 

1.3.1
* catch up 1.2.3 update

1.3
* Add a method to detect if a string is an integer #21 

1.2.3
* `Osgl.findPropertyParameterizedType` method shall treat array as List #22 

1.2.2
* `Osgl.getProperty` shall pickup the first element in an iterable if index not provided #20 
* `Osgl.getProperty` API shall handle array like a list #19 

1.2.1
* Treat `Locale` as simple type #18 
* Performance issue with `S.concat(...)` API #17 

1.2.0
* Add `Osgl.fill(element, array)` API methods #16 
* Add `IO.readLines(URL)` method #15 
* Add `N.isNumeric(String)` utility method #14 
* Add `N.isNegative(BigDecimal)`,`N.isNegative(BigNumber)` ... methods  #13 
* Add `S.padLeft` and `S.padRight` methods #12 

1.1.0
* Add new corresponding API for Osgl.asEnum(Class, String) and make it support case sensitive enum evaluation #6 
* Add `S.dos2unix(String)` and `S.unix2dos(String)` method #9 
* Add `S.concat(Object ...)` methods #10

1.0.3
* Fix issue #8 NPE on Generics.typeParamImplementations when passed in class is an interface

1.0.2
* Fix issue #7 - FastStr.contentEquals failed when begin cursor is greater than size

1.0.1
* Fix issue #5 - Osgl.asEnum(Class, String) API should be null safe

1.0
* base line from 0.11

0.11
* S.builder() APIs now reuse StringBuilder instance through ThreadLocal
* S.buffer() APIs is created to replace S.builder() APIs
* Added Osgl.asEnum(Class<? extends Enum>, String) API
* Add S.concat(String ...) API
* Add S.ensureEndsWith and S.ensureStartsWith API
* Add S.pathConcat API
* Add S.quote API
* Remove commons-codec from dependencies
* Add Codec.UTF_8 constant
* Add C.empty(Map) APIs
* Use ThreadLocalRandom to replace new Random
* Add Generics.buildTypeParamImplLookup(Class) API

0.10
* IO.copy now returns the number of bytes copied
* S.lowerFirst(String) API

0.9
* Provide better support for Iterator and Enumeration
* Move CacheService interface from osgl-cache to osgl-tool
* #2: add C.List.split(Predicate) function
* #3: Add KVStore.toMap() method
* Add IO.loadProperties(File) method
* Add IO.loadProperties(InputStream) method
* Add IO.loadProperties(String) method
* Add IO.loadProperties(Reader) method
* Add BigDecimalValueObjectCodec
* Fix ValueObject.toJSONString() issue when type is String and content contains illegal character, .e.g (")
* Fix issue in S.COMMON_SEP, change "[,;:\\s]" to "[,;:\\s]+"
* Add $.F.identity(Class) method
* Add Keyword utility
* Add N.isPerfectSquare(long) method
* Add $.IS_SERVER flag
* Add $.IS_64 flag
* Add FastStr.of(byte[], String) factory method
* Add IO.readLine(xxx, int limit) APIs to allow read limit lines from file/inputstream/reader
* Crypto encrypt and decrypt methods now accept byte[] as key and salt
* Add $.fieldOf(Class, String, Boolean) method
* Make Const class implement Serializable
* Add $.getMethod(Class, String, Class[]) method
* Add KV interface (implemented by KVStore)
* Add FastJsonKvCodec (fastjson serialize/deserialize KV) and FastJsonObjectCodec (convert JSONObject to/from ValueObject)
* Add Osgl.F.propertyExtractor API

0.8
* Rename "_" to "O" as "$" will be an illegal identifier after Java 8
* Increase unit test coverage
* Improve JavaDoc quality

0.7.0-SNAPSHOT
* _.newInstance(String) now will pass the Caller's class loader
* rename C.List.sort to C.List.sorted to avoid conflict with Java 8 List.sort
* rename StrBase.chars - StrBase.charArray to avoid conflict with Java 8 CharSequence.chars
* Add static T NPE(T) to osgl (_) class
* Add encodeUrlSafeBase64 and decodeUrlSafeBase64 method to Codec
* Add genSecret, genRandomDigit, genRandomStr to Crypto

0.7.1-SNAPSHOT
* Fix issue _.newInstance(...) failure when there are overloaded constructor with first parameter type is the same
* Add T _.async(_.F0<T>, long)
* Add N.round(float, int) and N.round(double, int) method
* Add C.Sequence.count(T) method

0.6.0-SNAPSHOT
* Add S.uuid() method
* Add new reader() and is() method to IO class dealing with URL and InputStreamReader
* Add eq2(Object, Object) to _, to allow do equal matching against two arrays
* Add asPrimitive() method set to _, to allow convert Object array to primitive array
* Add toString2() to _ to output array type object in a good format
* Add COMMON_SEP to S; add SPLIT and split(String) to S.F
* Better handling of primitive types in S.newInstance and S.classForName
* S.builder now accept primitive types and object types as constructor; original S.builder(int) semantic is now expressed in S.sizedBuilder(int)
* Add append(String) and prepend(String) functor to S.F
* Add reverse(array) methods to _
* add doFillInStackTrace to FastRuntimeException
* Fix issue: S.capFirst() throw StringIndexOutfBoundsException when parameter is empty string
* C.List.insert() now accept negative number to count the insert position from tail to head
* Add _.nil() method

0.5.5-SNAPSHOT
* Add C.List.unique(Comparator<T>) method

0.5.4-SNAPSHOT
* support primitives in _.forClassName and _.newInstace methods

0.5.3-SNAPSHOT
* add CONTAINS and contains to S.F

0.5.2-SNAPSHOT
* add random(List list) to _

0.5.1-SNAPSHOT
* Enhance Crypto encrypt/decrypt algorithm

0.5.0-SNAPSHOT
* _.Var implements _.Func0 so we can use it to implement "constant function" that
  takes a value and returns it when needed

0.4.5-SNAPSHOT
* ListBase.unique not working as expected

0.4.4-SNAPSHOT
* C.list(List) shouldn't sort the list
* Add S.F.IS_BLANK function
* Add S.F.NULL_SAFE function

0.4.3-SNAPSHOT
* Fix FeatureBase::setFeature NPE issue

0.4.2-SNAPSHOT
* Add "unique" to "C.List"
* remove "generalVisitor(final Function<? super T, ?> f)" from "_".
  "_.visitor(final Function<? super T, ?> f)" should be used instead

0.4.1-SNAPSHOT
* Add "public static ISObject zip(ISObject... objects)" method to IO utiltiy class

0.4-SNAPSHOT
* S.empty(String) now do not trim the string being passed in,
* Added S.blank(String) with the same semantic of previous S.empty(String)
* Fixed FastStr trim issue when begin, end pointer is not at default position
* FastStr now works with Java 6
* Unsafe now works with Java 6
* C enhancements:
** Set: add withIn, without, onlyIn for set operations
** added new set() method allows passing an collection to prepopulate the set
* OSGL updates:
** new classForName method allows passing class loader to load the class
* Iterators now is public class
* ListBuilder's new factor method allows passing initial capacity parameter

0.3.1-SNAPSHOT
* Added: ContextLocal, FastStr, Unsafe

0.3-SNAPSHOT
* base version when history log started
