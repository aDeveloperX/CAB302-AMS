package junit.BioLibrary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BioLibraryTests {

    junit.BioLibrary.Sequence sequence;

    @BeforeEach
    public void setup(){
        sequence = null;
    }
    @Test
    public void testDNAConstructerException(){
        try {
            sequence = new junit.BioLibrary.Sequence("ACGTACGF", junit.BioLibrary.Type.DNA);
            fail();
        }catch (junit.BioLibrary.SequenceException e){
            assertEquals("DNA must contain only the letters A, C, G, and T.", e.getMessage());
        }
    }
    @Test
    public void testRNAConstructerException(){
        try {
            sequence = new junit.BioLibrary.Sequence("AUGCAUGF", junit.BioLibrary.Type.RNA);
            fail();
        }catch (junit.BioLibrary.SequenceException e){
            assertEquals("RNA must contain only the letters A, U, G, and C.", e.getMessage());
        }
    }
    @Test
    public void testStaticConstrcuter(){
        try {
            sequence = new junit.BioLibrary.Sequence("AUGCAUG", junit.BioLibrary.Type.RNA);
            junit.BioLibrary.Sequence sequence1 = new junit.BioLibrary.Sequence("ACGTACG", junit.BioLibrary.Type.DNA);
            assertNotEquals(sequence, sequence1);
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }

    }

    @Test
    public void testDNAtoString(){
        String sequencename = "ACGTACGTACGT";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.DNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            assertEquals(sequencename, sequence.toString());
        }catch (junit.BioLibrary.SequenceException e){
            assertEquals(null, e.getMessage());
        }
    }
    @Test
    public void testRNAtoString(){
        String sequencename = "AUGCAUGCAUGC";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.RNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            assertEquals(sequencename, sequence.toString());
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }
    }
    @Test
    public void testPeptidetoString(){
        String sequencename = "ABCDABCDABCD";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.Peptide;
        try{
           sequence = new junit.BioLibrary.Sequence(sequencename, type);
            assertEquals(sequencename, sequence.toString());
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }
    }
    @Test
    public void testDNAgetType(){
        String sequencename = "ACGT";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.DNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            assertEquals(type, sequence.getType());
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }
    }
    @Test
    public void testRNAgetType(){
        String sequencename = "AUGC";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.RNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            assertEquals(type, sequence.getType());
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }
    }
    @Test
    public void testPeptidegetType(){
        String sequencename = "ABCDABCDABCD";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.Peptide;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            assertEquals(type, sequence.getType());
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }
    }
    @Test
    public void testDNAreverseComplement() {
        String sequencename = "AACCGGTTA";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.DNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            sequence.reverseComplement();
            assertEquals("TTGGCCAAT", sequence.toString());
        } catch (junit.BioLibrary.SequenceException e) {
           fail();
        }
    }
    @Test
    public void testRNAreverseComplement() {
        String sequencename = "AAUUGGCCA";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.RNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            sequence.reverseComplement();
            assertEquals("UUAACCGGU", sequence.toString());
        } catch (junit.BioLibrary.SequenceException e) {
           fail();
        }
    }
//    @Test
//    public void testDNAtoRNAreverseComplement() {
//        String sequencename = "AAGGTTCCA";
//        junit.BioLibrary.Type type = junit.BioLibrary.Type.RNA;
//        try {
//            junit.BioLibrary.Sequence sequence = new junit.BioLibrary.Sequence(sequencename, type);
//            assertEquals("TTCCAAGGT", sequence.reverseComplement());
//        } catch (junit.BioLibrary.SequenceException e) {
//            fail();
//        }
//    }
    @Test
    public void testReverseComplementException(){
        String sequencename = "ABCDABCD0";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.Peptide;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            sequence.reverseComplement();
            fail();
        }catch (junit.BioLibrary.SequenceException e){
            assertEquals("Undefined sequence type for reverse complement.", e.getMessage());
        }
    }
    @Test
    public void testDNAPalindromeTrue() {
        String sequencename = "ACCTAGGT";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.DNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            assertEquals(true, sequence.palindrome());
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }
    }
    @Test
    public void testDNAPalindromeFalse() {
        String sequencename = "ACGTA";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.DNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            assertEquals(false, sequence.palindrome());
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }
    }
    @Test
    public void testRNAPalindromeTrue() {
        String sequencename = "ACCUAGGU";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.RNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            assertEquals(true, sequence.palindrome());
        }catch (junit.BioLibrary.SequenceException e){
           fail();
        }
    }
    @Test
    public void testRNAPalindromeFalse() {
        String sequencename = "AUGC";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.RNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            assertEquals(false, sequence.palindrome());
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }
    }
    @Test
    public void testPeptidePalindrome() {
        String sequencename = "ABCDABCD";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.Peptide;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            sequence.palindrome();
            fail();
        }catch (junit.BioLibrary.SequenceException e){
            assertEquals("Undefined sequence type for reverse complement.", e.getMessage());
        }
    }
    @Test
    public void testDNAtranscribetoString(){
        String sequencename = "ACTGT";
        String expectsequence = "ACUGU";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.DNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            sequence.transcribe();
            assertEquals(expectsequence, sequence.toString());
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }
    }
    @Test
    public void testRNAtranscribetoString(){
        String sequencename = "AUUGG";
        String expectsequence = "ATTGG";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.RNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            sequence.transcribe();
            assertEquals(expectsequence, sequence.toString());
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }
    }
    @Test
    public void testDNAtranscribegetType(){
        String sequencename = "ACCTAGGT";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.DNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            sequence.transcribe();
            assertEquals(junit.BioLibrary.Type.RNA, sequence.getType());
        }catch (junit.BioLibrary.SequenceException e){
            fail();
        }
    }
    @Test
    public void testRNAtranscribegetType(){
        String sequencename = "ACCUAGGU";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.RNA;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            sequence.transcribe();
            assertEquals(junit.BioLibrary.Type.DNA, sequence.getType());
        }catch (junit.BioLibrary.SequenceException e){
           fail();
        }
    }
    @Test
    public void testPeptidetranscribeException(){
        String sequencename = "JAJHDE";
        junit.BioLibrary.Type type = junit.BioLibrary.Type.Peptide;
        try {
            sequence = new junit.BioLibrary.Sequence(sequencename, type);
            sequence.transcribe();
            fail();
        }catch (junit.BioLibrary.SequenceException e){
            assertEquals("Undefined sequence type for transcription.", e.getMessage());
        }
    }

}