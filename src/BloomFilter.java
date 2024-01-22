//public class BloomFilter {
//    private int filter_len;
//    private int bitArray;
//
//    public BloomFilter(int f_len) {
//        filter_len = f_len;
//        bitArray = 0;
//    }
//
//    // хэш-функции
//    public int hash1(String str1) {
//        int result = 0;
//        for (int i = 0; i < str1.length(); i++) {
//            int code = (int) str1.charAt(i);
//            result = (result * 17 + code) % filter_len;
//        }
//        return result;
//    }
//
//    public int hash2(String str1) {
//        int result = 0;
//        for (int i = 0; i < str1.length(); i++) {
//            int code = (int) str1.charAt(i);
//            result = (result * 223 + code) % filter_len;
//        }
//        return result;
//    }
//
//    public void add(String str1) {
//        int hash1 = hash1(str1);
//        int hash2 = hash2(str1);
//
//        setBit(hash1);
//        setBit(hash2);
//    }
//
//    public boolean isValue(String str1) {
//        int hash1 = hash1(str1);
//        int hash2 = hash2(str1);
//
//        return getBit(hash1) && getBit(hash2);
//    }
//
//    private void setBit(int index) {
//        bitArray = bitArray | (1 << index);
//    }
//
//    private boolean getBit(int index) {
//        return (bitArray & (1 << index)) != 0;
//    }
//}