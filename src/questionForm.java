
import java.awt.Color;
import java.io.IOException;
import roundedFields.roundedPanel;
import fontPackage.fontStyles;
import java.awt.FontFormatException;
import java.util.logging.Level;
import java.util.logging.Logger;
import images.imageNames;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.JDialog;
import QA.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import dbConn.oraDBCredentials;
import java.sql.DriverManager;
import java.sql.SQLException;
import colors.colors;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

/**
 *
 * @author kevin
 */
public class questionForm extends javax.swing.JDialog {
    oraDBCredentials db = new oraDBCredentials();
    private int points = 0;
    public int difficulty, account_id, rightAns;
    public String subject;
    /**
     * Creates new form questionForm
     * @throws java.awt.FontFormatException
     * @throws java.io.IOException
     */
    public questionForm(String sub, int diff, int acc_id) throws FontFormatException, IOException, SQLException {
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        initComponents();
        this.getContentPane().setBackground(new Color(133, 219, 217));
        this.setTitle("Questionnaire");
        this.setLocationRelativeTo(null);
        setFonts();
        setImages();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        difficulty = diff;
        account_id = acc_id;
        subject = sub;
        setSubj();
    }

    private questionForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setSubj() throws FontFormatException, IOException, SQLException{
        switch(subject){
            case "Science":
                scienceQuestions();
                break;
            case "English":
                englishQuestions();
                break;
            case "Math":
                mathQuestions();
                break;
            case "Geography":
                geographyQuestions();
                break;
            case "MusicArts":
                musicArtsQuestions();
                break;
            default:
                JOptionPane.showMessageDialog(null, "An error occured. Please report this to the administrator.");
                System.exit(0);
                break;
        }
    }
    
    public List<questionsAndAnswers> questions = new ArrayList<>();
    void scienceQuestions() throws FontFormatException, IOException, SQLException{
        if(difficulty == 1){
            questions.add(new questionsAndAnswers("Which animal lays eggs?",new String[]{"Dog","Cat","Duck","Sheep"},"Duck"));
            questions.add(new questionsAndAnswers("A male cow is called?",new String[]{"Ox","Dog","Sheep","Monkey"},"Ox"));
            questions.add(new questionsAndAnswers("All animals need food, air, and ___ to survive.",new String[]{"House","Water","Chocolate","Fruits"},"Water"));
            questions.add(new questionsAndAnswers("Which part of the bird lets it fly high in the sky?",new String[]{"Beak","Feet","Wings","Claws"},"Wings"));
            questions.add(new questionsAndAnswers("What part of the plant conducts photosynthesis?",new String[]{"Branch","Leaf","Root","Trunk"},"Leaf"));
            questions.add(new questionsAndAnswers("Which is the largest land animal?",new String[]{"Lion","Tiger","Elephant","Rhinoceros"},"Elephant"));
            questions.add(new questionsAndAnswers("Which animal from the below list is best adapted to the desert?",new String[]{"Tiger","Cheetah","Camel","Deer"},"Camel"));
            questions.add(new questionsAndAnswers("What is the name of a frog's young one?",new String[]{"Infant","Puppy","Calf","Tadpole"},"Tadpole"));
            questions.add(new questionsAndAnswers("Which is the largest animal on earth?",new String[]{"Shark","Elephant","Blue whale","Giraffe"},"Blue whale"));
            questions.add(new questionsAndAnswers("Which animal bears a fur?",new String[]{"Crocodile","Hen","Cat","Tortoise"},"Cat"));
            questions.add(new questionsAndAnswers("A branch of a tree can have green?",new String[]{"Root","Hair","Trunk","Leaves"},"Leaves"));
            questions.add(new questionsAndAnswers("Which of the following organs covers and protects the whole body?",new String[]{"Heart","Liver","Brain","Skin"},"Skin"));
            questions.add(new questionsAndAnswers("Feet are the part of legs and _____ are the part of arms?",new String[]{"Pelvis","Ankles","Skull","Hands"},"Hands"));
            questions.add(new questionsAndAnswers("Which shape looks round?",new String[]{"Circle","Rectangle","Triangle","Square"},"Circle"));
            questions.add(new questionsAndAnswers("A cow gives birth to a young?",new String[]{"Kitten","Puppy","Baby","Calf"},"Calf"));
        }else{
            questions.add(new questionsAndAnswers("What is Earth's only natural satellite?",new String[]{"Sun","Mars","Venus","Moon"},"Moon"));
            questions.add(new questionsAndAnswers("What part of the body helps you move?",new String[]{"Eyes","Lungs","Pancreas","Muscles"},"Muscles"));
            questions.add(new questionsAndAnswers("The two holes of the nose are called?",new String[]{"Eyelids","Nostrils","Nails","Hair"},"Nostrils"));
            questions.add(new questionsAndAnswers("What star shines in the day and provides light?",new String[]{"Moon","Venus","Mars","Sun"},"Sun"));
            questions.add(new questionsAndAnswers("Dark rain clouds can give out lightning and ___?",new String[]{"Thunder","Snow","Sunlight","Wind"},"Thunder"));
            questions.add(new questionsAndAnswers("What is the boiling point of water?",new String[]{"25°C","50°C","75°C","100°C"},"100°C"));
            questions.add(new questionsAndAnswers("___ helps pump blood through the entire body.",new String[]{"Lungs","Kidneys","Heart","Brain"},"Heart"));
            questions.add(new questionsAndAnswers("A state of matter that has indefinite shape and copies the shape of a container",new String[]{"Solid","Liquid","Gas","None of the Above"},"Liquid"));
            questions.add(new questionsAndAnswers("Frogs are ___?",new String[]{"Amphibian","Reptile","Mammal","Vertebrates"},"Amphibian"));
            questions.add(new questionsAndAnswers("When you push something, you apply ___.",new String[]{"Force","Acceleration","Mass","Compression"},"Force"));
            questions.add(new questionsAndAnswers("Which pigment gives the leaves its green color?",new String[]{"Chlorophyll","Synthesis","Photosynthesis","Ion"},"Chlorophyll"));
            questions.add(new questionsAndAnswers("Which nutrient plays an essential role in muscle-building?",new String[]{"Protein","Carbohydrate","Iron","Fat"},"Protein"));
            questions.add(new questionsAndAnswers("Which scientist proposed the three laws of motion?",new String[]{"Isaac Newton","Thomas Alva Edison","Albert Einstein","Stephen Hawking"},"Isaac Newton"));
            questions.add(new questionsAndAnswers("Earth is surrounded by layers of gases collectively called the ___?",new String[]{"Hydrosphere","Stratosphere","Atmosphere","Ozone layer"},"Atmosphere"));
            questions.add(new questionsAndAnswers("What energy emerges from motion?",new String[]{"Potential energy","Electrical energy","Kinetic energy","Gravitational energy"},"Kinetic energy"));
        }
        shuffleQuestions();
    }
    void englishQuestions() throws FontFormatException, IOException, SQLException{
        if(difficulty == 1){
            questions.add(new questionsAndAnswers("Identify the noun/s in this sentence.<br/><br/>I live in Amsterdam.",new String[]{"In","Live","Amsterdam","I"},"Amsterdam"));
            questions.add(new questionsAndAnswers("Identify the noun/s in this sentence.<br/><br/>I visited the Eiffel Tower in Paris.",new String[]{"The","Paris","Eiffel Tower and Paris","Eiffel Tower "},"Eiffel Tower and Paris"));
            questions.add(new questionsAndAnswers("Identify the noun/s in this sentence.<br/><br/>The mailman Mr. Joe was carrying postcards.",new String[]{"Mailman","Mr.Joe","Postcards","Mailman, Mr. Joe and postcards"},"Mailman, Mr. Joe and postcards"));
            questions.add(new questionsAndAnswers("Identify the noun/s in this sentence.<br/><br/>Are these mangoes tasty?",new String[]{"Tasty","Are","These","Mangoes"},"Mangoes"));
            questions.add(new questionsAndAnswers("Identify the noun/s in this sentence.<br/><br/>Hello Sophie! Will you play football with us as the climate is beautiful and the team is one player short?",new String[]{"Football","Sophie, football, climate, team, player","Team","Climate"},"Sophie, football, climate, team, player"));
            questions.add(new questionsAndAnswers("Identify the verb/s in this sentence.<br/><br/>The accountant is calculating the expenditure for the month of February",new String[]{"Accountant","Calculating","Month","Expenditure"},"Calculating"));
            questions.add(new questionsAndAnswers("Identify the verb/s in this sentence.<br/><br/>Jack left in a hurry.",new String[]{"A","Hurry","Jack","Left"},"Left"));
            questions.add(new questionsAndAnswers("Identify the adverb/s in this sentence.<br/><br/>Marcus always arrives early.",new String[]{"Arrives","Always","Early","Marcus"},"Always"));
            questions.add(new questionsAndAnswers("Identify the adverb/s in this sentence.<br/><br/>The students had worked very hard.",new String[]{"Students","Worked","Very","Hard"},"Hard"));
            questions.add(new questionsAndAnswers("Identify the adjective/s in this sentence.<br/><br/>Linda Mckenzie has five children.",new String[]{"Linda","Has","Children","Five"},"Five"));
            questions.add(new questionsAndAnswers("Identify the adverb/s in this sentence.<br/><br/>Brisk walking is a healthy exercise.",new String[]{"Brisk","Healthy","A","Walking"},"Brisk"));
            questions.add(new questionsAndAnswers("Identify the adjective/s in this sentence.<br/><br/>This store has a nice collection of shoes.",new String[]{"Store","Collection","Nice","Shoes"},"Nice"));
            questions.add(new questionsAndAnswers("Identify the pronoun/s in this sentence.<br/><br/>They were having dinner.",new String[]{"Dinner","They","Were","Having"},"They"));
            questions.add(new questionsAndAnswers("Identify the pronoun/s in this sentence.<br/><br/>Everyone is sleeping in the dorm room.",new String[]{"Sleeping","Dorm","Room","Everyone"},"Everyone"));
            questions.add(new questionsAndAnswers("Identify the pronoun/s in this sentence.<br/><br/>Would you like to have coffee?",new String[]{"Coffee","Have","You","Would"},"You"));
        }else{
            questions.add(new questionsAndAnswers("The students are ________ their notes.",new String[]{"Wrote","Written","Writing","Write"},"Writing"));
            questions.add(new questionsAndAnswers("The doctor ___ out for ten minutes.",new String[]{"Go","Going","Gone","Went"},"Went"));
            questions.add(new questionsAndAnswers("The new restaurant ____ last week",new String[]{"Open","Opened","Opening","Start"},"Opened"));
            questions.add(new questionsAndAnswers("Identify the correct sentence.",new String[]{"My ATM pin number has three 8s.","My ATM pin number has three 8's","My ATM pin number has three 8s'","My ATM pin number has three 8s"},"My ATM pin number has three 8s."));
            questions.add(new questionsAndAnswers("Identify the correct sentence",new String[]{"The weather is wet, and windy and unpredictable.","The weather is wet, windy and unpredictable.","The weather is wet, windy, unpredictable.","The weather is wet windy, unpredictable."},"The weather is wet, windy and unpredictable."));
            questions.add(new questionsAndAnswers("Identify the correct sentence.",new String[]{"Waiting for the storm to stop, I was anxiously looking out of the window","Waiting, for the storm to stop; I was anxiously looking out of the window.","Waiting for the storm to stop I was anxiously looking out of the window","Waiting for the storm to stop I was anxiously looking out of the window."},"Waiting for the storm to stop, I was anxiously looking out of the window."));
            questions.add(new questionsAndAnswers("Identify the correct sentence.",new String[]{"What is the name of your father’s uncle","What is the name of your father’s uncle?","What is the name of your fathers uncle?","What is the name of your, fathers’ uncle"},"What is the name of your father’s uncle?"));
            questions.add(new questionsAndAnswers("Correct the statement with a suitable punctuation mark.<br/><br/>When will you return from your dance rehearsal",new String[]{"Question mark (?)","Exclamation mark (!)","Fullstop (.)","Comma (,)"},"Question mark (?)"));
            questions.add(new questionsAndAnswers("Identify the synonym of this word.<br/><br/>Listen",new String[]{"Hear","Quiet","Play","Whisper"},"Hear"));
            questions.add(new questionsAndAnswers("Identify the synonym of this word.<br/><br/>Relax",new String[]{"Sleep","Sit","Rest","Lie down"},"Rest"));
            questions.add(new questionsAndAnswers("Identify the synonym of this word.<br/><br/>Positive",new String[]{"Optimistic","Negative","Addition","Neutral"},"Optimistic"));
            questions.add(new questionsAndAnswers("Identify the antonym of this word.<br/><br/>Comic",new String[]{"Tragic","Scenic","Laugh","Loud"},"Tragic"));
            questions.add(new questionsAndAnswers("Choose the correct spelling.<br/><br/>I have a _____.",new String[]{"Tooth Ache","Toothace","Tuthach","Toothache"},"Toothache"));
            questions.add(new questionsAndAnswers("Choose the correct spelling.<br/><br/>Businesses are having a tough time in the current market ______.",new String[]{"Scene","Cenario","Scenario","Scenery"},"Scenario"));
            questions.add(new questionsAndAnswers("Choose the correct spelling.<br/><br/>______ spend most of their time on research.",new String[]{"Scientists","Scintist","Scintests","Scienntists"},"Scientists"));
        }
       shuffleQuestions();
    }
    void geographyQuestions() throws FontFormatException, IOException, SQLException{
        if(difficulty == 1){
            questions.add(new questionsAndAnswers("Which is the largest country in the world?",new String[]{"America","Australia","Africa","Russia"},"Russia"));
            questions.add(new questionsAndAnswers("Which country has the largest population in the world?",new String[]{"China","Philippines","India","America"},"China"));
            questions.add(new questionsAndAnswers("Which is a name of an ocean?",new String[]{"Carribean","Okhotsk","Mediterranean","Southern"},"Southern"));
            questions.add(new questionsAndAnswers("How many states of India share its border with Bhutan?",new String[]{"4","5","3","1"},"4"));
            questions.add(new questionsAndAnswers("What is the capital city of India?",new String[]{"Mumbai","New Delhi","Bangalore","Hyderabad"},"New Delhi"));
            questions.add(new questionsAndAnswers("In which country would you find the Leaning Tower of Pisa?",new String[]{"Rome","Greece","France","Italy"},"Italy"));
            questions.add(new questionsAndAnswers("What is the largest continent of the world?",new String[]{"America","Europe","Asia","Antartica"},"Asia"));
            questions.add(new questionsAndAnswers("Which is colder?",new String[]{"North Pole","South Pole","Greenland","Iceland"},"South Pole"));
            questions.add(new questionsAndAnswers("Which planet is nearest to the Earth?",new String[]{"Mercury","Uranus","Jupiter","Venus"},"Venus"));
            questions.add(new questionsAndAnswers("Which is the biggest ocean on Earth?",new String[]{"Pacific Ocean","Atlantic Ocean","Indian Ocean","Southern Ocean"},"Pacific Ocean"));
            questions.add(new questionsAndAnswers("The United States consists of how many states?",new String[]{"56","49","53","50"},"50"));
            questions.add(new questionsAndAnswers("Which is the largest waterfall in the world?",new String[]{"Iguazu Falls","Victoria Falls","Havasu Falls","Niagra Falls"},"Victoria Falls"));
            questions.add(new questionsAndAnswers("Which is the biggest desert in the world?",new String[]{"Namib Desert","Atacama Desert","Sahara Desert","Gobi Desert"},"Sahara Desert"));
            questions.add(new questionsAndAnswers("Which is the hottest continent on Earth?",new String[]{"Asia","Antarctica","Africa","Australia"},"Africa"));
            questions.add(new questionsAndAnswers("Which is the highest mountain in the world?",new String[]{"Mount Fuji","Mount Everest","Mount Apo","Mount K2"},"Mount Everest"));
        }else{
            questions.add(new questionsAndAnswers("Which is the most populous city in the United Kingdom which is also its capital city?",new String[]{"Birmingham","Bradford","London","Wolverhampton"},"London"));
            questions.add(new questionsAndAnswers("Which river forms part of the boundary between Mexico and the United States?",new String[]{"Rio Grande","Nile","Yangtze","Missouri"},"Rio Grande"));
            questions.add(new questionsAndAnswers("Which country is also known as the Netherlands?",new String[]{"Poland","Switzerland","Denmark","Holland"},"Holland"));
            questions.add(new questionsAndAnswers("Which is the country with the most number of capital cities?",new String[]{"United States of America","China","England","South Africa"},"South Africa"));
            questions.add(new questionsAndAnswers("In which American city is the Golden Gate Bridge located?",new String[]{"New York","San Francisco","Los Angeles","Chicago"},"San Francisco"));
            questions.add(new questionsAndAnswers("Which is the coldest place on Earth?",new String[]{"Alaska","Antarctica","Russia","Greenland"},"Antarctica"));
            questions.add(new questionsAndAnswers("In which part of the river does the water flows the fastest?",new String[]{"Lower course","Middle course","Upper course","Straight course"},"Upper course"));
            questions.add(new questionsAndAnswers("What is the capital city of Spain?",new String[]{"Barcelona","Madrid","Palma de Mallorca","Granada"},"Madrid"));
            questions.add(new questionsAndAnswers("In which country would you find Mount Kilimanjaro?",new String[]{"Japan","Philippines","Zimbabwe","Tazmania"},"Tazmania"));
            questions.add(new questionsAndAnswers("Which is the largest lake in the world?",new String[]{"Caspian Sea","Superior","Victoria","Huron"},"Caspian Sea"));
            questions.add(new questionsAndAnswers("What are the imaginary lines around the earth called?",new String[]{"Margins","Parallels","Equator","Latitudes and Longitudes"},"Latitudes and Longitudes"));
            questions.add(new questionsAndAnswers("Ceylon is the former name of which country?",new String[]{"Rome","Greece","Spain","Sri Lanka"},"Sri Lanka"));
            questions.add(new questionsAndAnswers("Which is the largest US state in terms of population?",new String[]{"California","Alabama","Delaware","Kansas"},"California"));
            questions.add(new questionsAndAnswers("What is the official language of Brazil?",new String[]{"English","Spanish","Portuguese","Hunsrik"},"Portuguese"));
            questions.add(new questionsAndAnswers("Which is the only country with a coastline on both the Red Sea and the Persian Gulf?",new String[]{"Oman","Dubai","Riyadh","Saudi Arabia"},"Saudi Arabia"));
        }
        shuffleQuestions();
    }
    void musicArtsQuestions() throws FontFormatException, IOException, SQLException{
        if(difficulty == 1){
            questions.add(new questionsAndAnswers("Starting with the letter 'X', which musical instrument consists of wooden bars struck by a mallet?",new String[]{"Xeroses","Xylophone","Xanthophore","Xylographical"},"Xylophone"));
            questions.add(new questionsAndAnswers("In the nursery song 'The Wheels on the Bus' what goes 'swish, swish, swish'?",new String[]{"The wipers on the bus","The wheels on the bus","The babies on the bus","The horn on the bus"},"The wipers on the bus"));
            questions.add(new questionsAndAnswers("A Piano has 88 keys – True or False?",new String[]{"True","False"},"True"));
            questions.add(new questionsAndAnswers("A violin has 6 strings – True or False?",new String[]{"True","False"},"False"));
            questions.add(new questionsAndAnswers("Strings on a Guitar are different thicknesses – True or False?",new String[]{"True","False"},"True"));
            questions.add(new questionsAndAnswers("A group of two musicians or singers is called a couple – True or False?",new String[]{"True","False"},"False"));
            questions.add(new questionsAndAnswers("Which percussion instrument is named after its shape?",new String[]{"Circle","Rhombus","Triangle","Trapezoid"},"Triangle"));
            questions.add(new questionsAndAnswers("What animal often symbolizes peace in art?",new String[]{"Dog","Duck","Deer","Dove"},"Dove"));
            questions.add(new questionsAndAnswers("What was the subject of the earliest known paintings?",new String[]{"Animals","Landscapes","Sports","Flowers"},"Animals"));
            questions.add(new questionsAndAnswers("Who was the first famous artist of the Italian Renaissance?",new String[]{"Michelangelo","Mantegna","Masaccio","Leonardo da Vinci"},"Masaccio"));
            questions.add(new questionsAndAnswers("Which of these painters did not work during the Renaissance?",new String[]{"Titian","Michelangelo","Raphael","Salvador Dali"},"Salvador Dali"));
            questions.add(new questionsAndAnswers("Which of these was not a Renaissance artist?",new String[]{"Henry Moore","Michelangelo","Raphael","Leon Battista Alberti"},"Henry Moore"));
            questions.add(new questionsAndAnswers("How many foot positions are there in ballet?",new String[]{"5","17","10","1"},"5"));
            questions.add(new questionsAndAnswers("What is the name for a traditional Argentine music and dance?",new String[]{"Toreador","Tango","Waltz","Jazz"},"Tango"));
            questions.add(new questionsAndAnswers("What is red and blue mixed together?",new String[]{"Purple","Brown","Green","Black"},"Purple"));
        }else{
            questions.add(new questionsAndAnswers("Which of these is a paint made from pigments and plastic?",new String[]{"Acrylic","Gesso","Acetone","Tempera"},"Acrylic"));
            questions.add(new questionsAndAnswers("Early photographers made their images on which of these materials?",new String[]{"Glass","Stone","Paper","Plastic"},"Glass"));
            questions.add(new questionsAndAnswers("To which artistic movement does Paul Gauguin’s The Yellow Christ belong?",new String[]{"Impressionism","Bauhaus","Cloisonnism","Fauvism"},"Cloisonnism"));
            questions.add(new questionsAndAnswers("What does the Venus of Brassempouy represent?",new String[]{"a woman’s head","an angel","a human figure","an old man"},"a woman’s head"));
            questions.add(new questionsAndAnswers("Which architect founded the Bauhaus school of design?",new String[]{"Walter Gropius","Frank Gehry","I.M. Pei","Frank Lloyd Wright"},"Walter Gropius"));
            questions.add(new questionsAndAnswers("Who designed the Vietnam Veterans Memorial?",new String[]{"Henri Matisse","Maya Lin","Frank Gehry","Frank Lloyd Wright"},"Maya Lin"));
            questions.add(new questionsAndAnswers("What did I.M. Pei design outside the Louvre, in Paris?",new String[]{"Sarcophagus","Obelisk","Ziggurat","Pyramid"},"Pyramid"));
            questions.add(new questionsAndAnswers("Which one of these is not a well-known Indian sculptor?",new String[]{"Ramkinkar Baij","Henry Moore","Kumaradeva","Krishna Reddy"},"Henry Moore"));
            questions.add(new questionsAndAnswers("What Dutch artist is famous for his strange geometrical puzzles??",new String[]{"M.C. Escher","Pieter Breughel","Vincent Van Gogh","Jan Van Eyk Reddy"},"M.C. Escher"));
            questions.add(new questionsAndAnswers("Which of these dances was popular in the 1920s?",new String[]{"Watusi","Charleston","Twist","Lambada"},"Charleston"));
            questions.add(new questionsAndAnswers("What is a small flute called?",new String[]{"Flutolo","Rucolo","Manolo","Piccolo"},"Piccolo"));
            questions.add(new questionsAndAnswers("What is the bow of a violin usually made from?",new String[]{"Rabbit fur","Human hair","Dog hair","Horse hair"},"Horse hair"));
            questions.add(new questionsAndAnswers("Which animal completes the title of this famous work by Prokofiev: Peter and the ____",new String[]{"Rabbit","Deer","Frog","Wolf"},"Wolf"));
            questions.add(new questionsAndAnswers("Which of these is a famous work by Mozart?",new String[]{"The Magic Flute","he Magic Trumpet","The Magic Violin","The Magic Piano"},"The Magic Flute"));
            questions.add(new questionsAndAnswers("Which member of an orchestra holds a baton?",new String[]{"Conductor","Principal violin","Percussionist","French horn player"},"Conductor")); 
        }
        shuffleQuestions();
    }
    void mathQuestions() throws FontFormatException, IOException, SQLException{
        if(difficulty == 1){
            questions.add(new questionsAndAnswers("How much is 65-43?",new String[]{"33","22","32","20"},"22"));
            questions.add(new questionsAndAnswers("What comes after billion and trillion?",new String[]{"Quadrillion","Million","Lakhs","Multi-trillion"},"Quadrillion"));
            questions.add(new questionsAndAnswers("52 divided by 4 equals what?",new String[]{"11","22","13","15"},"13"));
            questions.add(new questionsAndAnswers("Which is the biggest number?",new String[]{"Billion","Googol","Thousand","Trillion"},"Googol"));
            questions.add(new questionsAndAnswers("87 + 56 = ?",new String[]{"134","148","145","143"},"143"));
            questions.add(new questionsAndAnswers("How many sides do Nonagon contains?",new String[]{"10","9","8","7"},"9"));
            questions.add(new questionsAndAnswers("7 x 9 = ?",new String[]{"56","63","49","72"},"63"));
            questions.add(new questionsAndAnswers("How much is 24 x 2?",new String[]{"26","38","48","68"},"48"));
            questions.add(new questionsAndAnswers("How much is 222 + 83?",new String[]{"306","305","333","304"},"305"));
            questions.add(new questionsAndAnswers("Total degrees in Right Angle?",new String[]{"90","100","80","120"},"90"));
            questions.add(new questionsAndAnswers("What number should be added to 66 to get 121 as a sum?",new String[]{"55","66","60","44"},"55"));
            questions.add(new questionsAndAnswers("How much is 849 divided by 10?",new String[]{"84.9","84","80","90"},"84.9"));
            questions.add(new questionsAndAnswers("How many days and hours are equal to 200 hours?",new String[]{"8 days and 8 hours","9 days and 10 hours","20 days and 20 hours","0 days and 20 hours"},"8 days and 8 hours"));
            questions.add(new questionsAndAnswers("In 25,600, the place value of 6 is?",new String[]{"600","6","6000","60"},"600"));
            questions.add(new questionsAndAnswers("How many years complete a decade?",new String[]{"10","5","20","50"},"10")); 
        }else{
            questions.add(new questionsAndAnswers("The Next Primer number after 7 is?",new String[]{"10","11","8","14"},"11"));
            questions.add(new questionsAndAnswers("The perimeter of a circle is known as?",new String[]{"Square","Circumference11","Pie","Parallel"},"Circumference"));
            questions.add(new questionsAndAnswers("True or false? A convex shape curves outwards.",new String[]{"True","False"},"True"));
            questions.add(new questionsAndAnswers("Square root of 144?",new String[]{"12","11","24","13"},"12"));
            questions.add(new questionsAndAnswers("True or false? Pi can be correctly written as a fraction.",new String[]{"True","False"},"False"));
            questions.add(new questionsAndAnswers("True or false? Opposite angles of a parallelogram are equal.",new String[]{"True","False"},"True"));
            questions.add(new questionsAndAnswers("True or false? -2 is an integer.",new String[]{"True","False"},"True"));
            questions.add(new questionsAndAnswers("What is the next number in the Fibonacci sequence:<br/><br/>0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ?",new String[]{"51","55","46","50"},"55"));
            questions.add(new questionsAndAnswers("True or false? In an isosceles triangle all sides are unequal.",new String[]{"True","False"},"False"));
            questions.add(new questionsAndAnswers("In statistics, the middle value of an ordered set of values is called what?",new String[]{"Mode","Mean","Range","Median"},"Median"));
            questions.add(new questionsAndAnswers("What does 3 squared equal?",new String[]{"9","6","15","12"},"9"));
            questions.add(new questionsAndAnswers("-4 is a natural number. True or False?",new String[]{"True","False"},"False"));
            questions.add(new questionsAndAnswers("5 to the power of 0 equals what?",new String[]{"0","1","5","3"},"1"));
            questions.add(new questionsAndAnswers("0.75 is same as?",new String[]{"7.5%","750%","75%","0.075%"},"75%"));
            questions.add(new questionsAndAnswers("How many months are there in a century?",new String[]{"1200","120","12000","12"},"1200"));
        }
        shuffleQuestions();
    }
    void shuffleQuestions() throws FontFormatException, FontFormatException, IOException, IOException, SQLException{
        Collections.shuffle(questions);
        displayQuestion(questions);
    }
    
    private int i = 0;
    public questionsAndAnswers currQ;
    public void displayQuestion(List questions) throws FontFormatException, IOException, SQLException{
        if(i < questions.size()){
            currQ = (questionsAndAnswers) questions.get(i);
            Collections.shuffle(Arrays.asList(currQ.answers));
            lbl_question.setText("<html>"+currQ.question+"</html>");
            btn_a.setText("a. " +currQ.answers[0]);
            btn_b.setText("b. " +currQ.answers[1]);
            if(currQ.answers.length <= 2){
                btn_c.setVisible(false);
                btn_d.setVisible(false);
            }else{
                if(btn_c.isVisible() == false){
                    btn_c.setVisible(true);
                    btn_d.setVisible(true);
                }
                btn_c.setText("c. " +currQ.answers[2]);
                btn_d.setText("d. " +currQ.answers[3]);
            }
            i++;
        }else{
            updatePoints();
            this.dispose();
            congratsForm cong = new congratsForm(subject, account_id, difficulty, rightAns, points);
            cong.setVisible(true);
        }
    }
    void updatePoints() throws SQLException{
        db.conn = DriverManager.getConnection(db.DB_URL, db.USER, db.PASS);
        db.stmt = db.conn.createStatement();
            
            String sql = String.format("UPDATE %s "
                    + "SET points='%d' "
                    + "WHERE account_id='%d'",subject, points, account_id);
            db.stmt.executeUpdate(sql);
            db.conn.close();
    }
    final void setFonts() throws FontFormatException, FontFormatException, IOException{
        lbl_points.setFont(fontStyles.setMaely(24));
        /*lbl_question.setFont(fontStyles.setMaely(32));
        btn_a.setFont(fontStyles.setMaely(25));
        btn_b.setFont(fontStyles.setMaely(25));
        btn_c.setFont(fontStyles.setMaely(25));
        btn_d.setFont(fontStyles.setMaely(25));*/
        lbl_guide.setFont(fontStyles.setOpenSans(20));
        lbl_ptsNumber.setFont(fontStyles.setMaely(56));
    }
    
    final void setImages(){
        lbl_asteriskImg1.setIcon(imageNames.getImage(lbl_asteriskImg1.getWidth(),lbl_asteriskImg1.getHeight(),"*"));
        lbl_dblLoopImg1.setIcon(imageNames.getImage(lbl_dblLoopImg1.getWidth(),lbl_dblLoopImg1.getHeight(),"double"));
        lbl_questionMarkImg1.setIcon(imageNames.getImage(lbl_questionMarkImg1.getWidth(),lbl_questionMarkImg1.getHeight(),"?"));
        
        lbl_dblLoopImg1.setText(null);
        lbl_asteriskImg1.setText(null);
        lbl_questionMarkImg1.setText(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new roundedPanel(100);
        lbl_dblLoopImg1 = new javax.swing.JLabel();
        lbl_asteriskImg1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_points = new javax.swing.JLabel();
        lbl_ptsNumber = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_a = new javax.swing.JButton();
        btn_b = new javax.swing.JButton();
        btn_c = new javax.swing.JButton();
        btn_d = new javax.swing.JButton();
        lbl_guide = new javax.swing.JLabel();
        lbl_questionMarkImg1 = new javax.swing.JLabel();
        lbl_question = new javax.swing.JLabel();
        btn_quit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(824, 658));

        lbl_dblLoopImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dblLoopImg1.setText("Double Loop Img");

        lbl_asteriskImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_asteriskImg1.setText("Asterisk Img");

        jPanel2.setBackground(new java.awt.Color(253, 233, 255));

        lbl_points.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_points.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_points.setText("Points");

        lbl_ptsNumber.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_ptsNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ptsNumber.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_ptsNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_points, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_points, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ptsNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btn_a.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_a.setText("a. Dog");
        btn_a.setContentAreaFilled(false);
        btn_a.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_aMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_aMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_aMouseExited(evt);
            }
        });

        btn_b.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_b.setText("b. Cat");
        btn_b.setContentAreaFilled(false);
        btn_b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_bMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_bMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_bMouseExited(evt);
            }
        });

        btn_c.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_c.setText("c. Duck");
        btn_c.setContentAreaFilled(false);
        btn_c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cMouseExited(evt);
            }
        });

        btn_d.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_d.setText("d. Sheep");
        btn_d.setContentAreaFilled(false);
        btn_d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_c, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_b, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_a, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_b, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_c, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_d, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        lbl_guide.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_guide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_guide.setText("Click on your answer");

        lbl_questionMarkImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_questionMarkImg1.setText("Question Mark Img");

        lbl_question.setFont(new java.awt.Font("Times New Roman", 0, 32)); // NOI18N
        lbl_question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_question.setText("1. Which animal lays eggs?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lbl_questionMarkImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_guide)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_asteriskImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lbl_dblLoopImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_question, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_dblLoopImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_question, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_asteriskImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_guide, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_questionMarkImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btn_quit.setText("X");
        btn_quit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_quitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addComponent(btn_quit, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btn_quit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aMouseEntered
        // TODO add your handling code here:
        btn_a.setForeground(colors.green);
    }//GEN-LAST:event_btn_aMouseEntered

    private void btn_aMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aMouseExited
        // TODO add your handling code here:
        btn_a.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_aMouseExited

    private void btn_bMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bMouseEntered
        // TODO add your handling code here:
        btn_b.setForeground(colors.green);
    }//GEN-LAST:event_btn_bMouseEntered

    private void btn_bMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bMouseExited
        // TODO add your handling code here:
        btn_b.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_bMouseExited

    private void btn_cMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cMouseEntered
        // TODO add your handling code here:
        btn_c.setForeground(colors.green);
    }//GEN-LAST:event_btn_cMouseEntered

    private void btn_cMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cMouseExited
        // TODO add your handling code here:
        btn_c.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_cMouseExited

    private void btn_dMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dMouseEntered
        // TODO add your handling code here:
        btn_d.setForeground(colors.green);
    }//GEN-LAST:event_btn_dMouseEntered

    private void btn_dMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dMouseExited
        // TODO add your handling code here:
        btn_d.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_dMouseExited

    private void btn_quitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_quitMouseClicked

    private void btn_aMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_aMouseClicked
        // TODO add your handling code here:
        if(btn_a.getText().substring(3).equals(currQ.correctAnswer)){
            setPoints();
            try {
                displayQuestion(questions);
            } catch (FontFormatException | IOException | SQLException ex) {
                Logger.getLogger(questionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                displayQuestion(questions);
            } catch (FontFormatException | IOException | SQLException ex) {
                Logger.getLogger(questionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_aMouseClicked

    private void btn_bMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bMouseClicked
        // TODO add your handling code here:
        if(btn_b.getText().substring(3).equals(currQ.correctAnswer)){
            setPoints();
            try {
                displayQuestion(questions);
            } catch (FontFormatException | IOException | SQLException ex) {
                Logger.getLogger(questionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                displayQuestion(questions);
            } catch (FontFormatException | IOException | SQLException ex) {
                Logger.getLogger(questionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_bMouseClicked

    private void btn_cMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cMouseClicked
        // TODO add your handling code here:
        if(btn_c.getText().substring(3).equals(currQ.correctAnswer)){
            try {
                setPoints();
                displayQuestion(questions);
            } catch (FontFormatException | IOException | SQLException ex) {
                Logger.getLogger(questionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                displayQuestion(questions);
            } catch (FontFormatException | IOException | SQLException ex) {
                Logger.getLogger(questionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_cMouseClicked

    private void btn_dMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dMouseClicked
        // TODO add your handling code here:
        if(btn_d.getText().substring(3).equals(currQ.correctAnswer)){
            setPoints();
            try {
                displayQuestion(questions);
            } catch (FontFormatException | IOException | SQLException ex) {
                Logger.getLogger(questionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                displayQuestion(questions);
            } catch (FontFormatException | IOException | SQLException ex) {
                Logger.getLogger(questionForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_dMouseClicked
    void setPoints(){
        if(difficulty == 1){
            points += 4;
        }else{
            points +=13;
        }
        rightAns++;
        lbl_ptsNumber.setText(String.valueOf(points));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(questionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(questionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(questionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(questionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new questionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_a;
    private javax.swing.JButton btn_b;
    private javax.swing.JButton btn_c;
    private javax.swing.JButton btn_d;
    private javax.swing.JButton btn_quit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_asteriskImg1;
    private javax.swing.JLabel lbl_dblLoopImg1;
    private javax.swing.JLabel lbl_guide;
    private javax.swing.JLabel lbl_points;
    private javax.swing.JLabel lbl_ptsNumber;
    private javax.swing.JLabel lbl_question;
    private javax.swing.JLabel lbl_questionMarkImg1;
    // End of variables declaration//GEN-END:variables
}
