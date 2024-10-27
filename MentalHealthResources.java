import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MentalHealthResources{
    
    public static void main(String[] args){

        // Welcome Messages
        System.out.println("Welcome to the Inner Strength Initiative Mental Health Education Outreach Assessment. This program is designed to help you assess your knowledge on mental health and provide you with resources to help you or someone you know who may be struggling with mental health issues. Please answer the following questions to the best of your ability.");
        
        System.out.print("\nDo you have any interest in learning more about the following specific mental health conditions and what they might look like/how to cope with them? (Please enter number associated with the condition you would like to learn more about:\n1. Depression\n2. Anxiety\n3. PTSD\n4. OCD\n6. None of the Above\nInput: ");
        int condition = Integer.parseInt(System.console().readLine());

        // Calls the appropriate function based on the users input
        if(condition == 1){
            depressionAssessment();
        } else if(condition == 2){
            anxietyAssessment();
        } else if(condition == 3){
            ptsdInfo();
        } else if(condition == 4){
            ocdAssessment();
        } else {
            System.out.print("Thats okay!)");
            generalMentalHealthAssessment();
        }


        // Wrap Up Message
        System.out.println("\n------------------------------------");
        System.out.println("Thank you so much for completing our Inner Strength Innitiative Mental Health Education Outcreach Assessment. Provided below are a few baseline resources that are extremely helpful to anyone regardless if you yourself are struggling with mental health issues. Even just being aware of these resources and organizations could help someone in need.");
        System.out.print("1. National Alliance on Mental Illness (NAMI) - https://www.nami.org/Home\n2. Mental Health America - https://www.mhanational.org/\n3. Substance Abuse and Mental Health Services Administration (SAMHSA) - https://www.samhsa.gov/\n4. American Psychological Association - https://www.apa.org/\n5. National Institute of Mental Health - https://www.nimh.nih.gov/index.shtml");

    }

    // General Function to assess users general knowledge about good basic mental health
    public static void generalMentalHealthAssessment(){
        System.out.println("\nDo you know what mental health is?");
        String response = System.console().readLine();

        // If the user knows what mental health is, then they are off to a good start, otherwise, educate on baseline
        if(response.equals("yes")){
            System.out.println("\nGreat! You're off to a good start. Then, as you know, two of the most crucial ways of maintaining good mental health, regardless of what mental conditions you might already have, are by getting adequate sleep and exercise.");
        } else {
            //Defines mental health and provides two crucial ways to maintain good mental health
            System.out.println("\nMental health is the state of well-being in which an individual realizes his or her own abilities, can cope with the normal stresses of life, can work productively and is able to make a contribution to his or her community.\nTwo of the most crucial ways of maintaining good mental health, regardless of what mental conditions you might already have, are by getting adequate sleep and exercise.");
        }


        // Sleep Specific Question Section
        System.out.println("Sleep Specific Questions\n");
        System.out.print("What is your age?: ");
        int age = Integer.parseInt(System.console().readLine()); // Inputs users age from terminal

        // Determines the correct amount of sleep for the user based on their age
        int correct;
        if(age < 6){
            correct = 10;
        } else if (age < 14){
            correct = 9;
        } else if (age < 18){
            correct = 8;
        } else if (age < 65){
            correct = 7;
        } else {
            correct = 6;
        }

        // Displays the correct amount of sleep for the user based on their age and if they are currently meeting that amount
        System.out.print("\nHow many hours of sleep do you get per night?: ");
        int hoursOfSleep = Integer.parseInt(System.console().readLine());

        if(hoursOfSleep == correct){
            System.out.println("\nGreat! You're getting the right amount of sleep for your age group.");
        } else if(hoursOfSleep < correct){
            System.out.println("\nThis is an inadequate amount of sleep. You should be getting at least " + correct + " hours of sleep per night for your age.");
        } else {
            System.out.println("\nYou should try to get less sleep as too much sleep can be just as detrimental as too little sleep.");
        }



        // Exercise Specific Question Section
        System.out.println("Exercise Specific Questions\n");

        //Describes Activity levels and asks User for their activity level
        System.out.println("Activity Levels (Provided by World Health Organization: \nSedentary - Only Activities of Daily Living (Sitting, Reading, Watching TV, etc.)\nLow Active - Activities of Daily living + Moderate Activity (Ex. Walking at a pace of 3-4 miles an hour daily)\nActive - Activities of daily living + At least 60 minutes of moderate activity\nVery Active - Activities of daily living + at least 60 miniutes of moderate activity + 120 minutes of moderate activity OR 60 minuts of vigorous activity (running, tennis, dance, etc.)");
        System.out.println("Out of the four categories provided above, which one do you think you fall under?: ");
        String activityLevel = System.console().readLine();

        if(activityLevel.equals("Sedentary") || activityLevel.equals("sedentary") || activityLevel.equals("Sedentary ") || activityLevel.equals("sedentary ")){
            System.out.println("Even low to moderate activity can increase the chances of improving your mental health. This could include casual walking, yoga, bicycling, etc");
        } else {
            System.out.println("Good Job! Any form of moderate to low physical activity can help improve your mental health by releasing chemicals responsible for improving mood such as dopamine (Mental Health Foundation). By keeping up this activity level, you are able to put yourself at a more advantageous position in regards to keeping up good Mental Health.");
        }

    }


    // Depression Function to with specific questions related to the condition
    public static void depressionAssessment(){
        // Sets variables necessary for the depression function
        int count = 0;
        String [] depressionResources = readFile("Depression.txt"); // Holds the resources for depression from txt file in a String array

        // Asks the user specific questions related to depression
        System.out.println("\nThe following questions are used to assess a persons standing with depression. This is NOT an official diagnosis; your result does not necessarily mean you are struggling with depression and each question might not even end up applying to you. However, thinking about these questions can help you understand the behaviors that are associated with depression. Please answer each question with a 0 (Not at all), 1 (Several Days), 2 (More than half the days), or 3 (Nearly every day).");
        System.out.print("1. Little interest of pleasure in doing things: ");
        count += Integer.parseInt(System.console().readLine());
        System.out.print("\n2. Feeling down, depressed, or hopeless: ");
        count += Integer.parseInt(System.console().readLine());
        System.out.print("\n3. Trouble falling or staying asleep, or sleeping too much: ");
        count += Integer.parseInt(System.console().readLine());
        System.out.print("\n4. Feeling tired or having little energy: ");
        count += Integer.parseInt(System.console().readLine());
        System.out.print("\n5. Poor appetite or overeating: ");
        count += Integer.parseInt(System.console().readLine());
        System.out.print("\n6. Feeling bad about yourself - or that you are a failure or have let yourself or your family down: ");
        count += Integer.parseInt(System.console().readLine());

        if(count <= 4){
            System.out.print("\nConsidering your responses, if we were to categorize the severity of Depression you may be experiencing, it would be considered minimal.\nWould you like to see some resources that could help you maintain good mental health and potentially prevent further depression? (Y/N):");
            String response = System.console().readLine();

            if(response.equals("Y") || response.equals("y") || response.equals("Y ") || response.equals("y ")){
                resourcesPrint(depressionResources); // resources for depression

                // Informs the user that they are going to carry on to the general mental health questions
                System.out.println("\n** The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject. **");
                generalMentalHealthAssessment();

            } else if (response.equals("N") || response.equals("n") || response.equals("N ") || response.equals("n ")){
                System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                generalMentalHealthAssessment();

            } else {
                System.out.println("Invalid Input. Please enter Y or N.");
                String response2 = System.console().readLine();

                if(response2.equals("Y") || response2.equals("y") || response2.equals("Y ") || response2.equals("y ")){
                    resourcesPrint(depressionResources); // Prints out resources for depression

                } else if (response2.equals("N") || response2.equals("n") || response2.equals("N ") || response2.equals("n ")){
                    System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                    generalMentalHealthAssessment();

                }
            }

        } else if (count <= 9){
            System.out.print("\nConsidering your responses, if we were to categorize the severity of Depression you may be experiencing, it would be considered mild.\nWould you like to see some resources that could help you maintain good mental health and potentially prevent further depression? (Y/N):");
            String response = System.console().readLine();

            if(response.equals("Y") || response.equals("y") || response.equals("Y ") || response.equals("y ")){
                resourcesPrint(depressionResources); // Prints out resources for depression

            } else if (response.equals("N") || response.equals("n") || response.equals("N ") || response.equals("n ")){
                System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                generalMentalHealthAssessment();

            }
        } else if (count <= 14){
            System.out.print("\nConsidering your responses, if we were to categorize the severity of Depression you may be experiencing, it would be considered moderate.\nWould you like to see some resources that could help you maintain good mental health and potentially prevent further depression? (Y/N):");
            String response = System.console().readLine();

            if(response.equals("Y") || response.equals("y") || response.equals("Y ") || response.equals("y ")){
                resourcesPrint(depressionResources); // Prints out resources for depression

            } else if (response.equals("N") || response.equals("n") || response.equals("N ") || response.equals("n ")){
                System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                generalMentalHealthAssessment();

            } else {
                System.out.println("Invalid Input. Please enter Y or N.");
                String response2 = System.console().readLine();

                if(response2.equals("Y") || response2.equals("y") || response2.equals("Y ") || response2.equals("y ")){
                    resourcesPrint(depressionResources); // Prints out resources for depression

                } else if (response2.equals("N") || response2.equals("n") || response2.equals("N ") || response2.equals("n ")){
                    System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                    generalMentalHealthAssessment();

                }
            }

        } else if (count <= 19){
            System.out.print("\nConsidering your responses, if we were to categorize the severity of Depression you may be experiencing, it would be considered moderately severe.\nWould you like to see some resources that could help you maintain good mental health and potentially prevent further depression? (Y/N):");
            String response = System.console().readLine();

            if(response.equals("Y") || response.equals("y") || response.equals("Y ") || response.equals("y ")){
                resourcesPrint(depressionResources); // Prints out resources for depression

            } else if (response.equals("N") || response.equals("n") || response.equals("N ") || response.equals("n ")){
                System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                generalMentalHealthAssessment();

            } else {
                System.out.println("Invalid Input. Please enter Y or N.");
                String response2 = System.console().readLine();

                if(response2.equals("Y") || response2.equals("y") || response2.equals("Y ") || response2.equals("y ")){
                    resourcesPrint(depressionResources); // Prints out esources for depression

                } else if (response2.equals("N") || response2.equals("n") || response2.equals("N ") || response2.equals("n ")){
                    System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                    generalMentalHealthAssessment();

                }
            }
        } else {
            System.out.println("\nConsidering your responses, if we were to categorize the severity of Depression you may be experiencing, it would be considered severe. The following links are crisis helplines that could help you in your time of need. (Provided by Mental Health America)");
            System.out.print("1. 988 Suicide & Crisis Lifeline: Call or text 988 or chat 988lifeline.org for immediate support | Operates 24/7\n2. Disaster Distress Helpline: Call or text 1-800-985-5990 to connect with a trained counselor 24/7\n3. The Trevor Project: Call 1-866-488-7386 or text START to 678678 for a 24/7 confidential suicide hotline for LGBTQIA2S+ youth\n4. National Domestic Violence Hotline: Call 1-800-799-7233 or log onto thehotline.org or text LOVEIS to 22522");

            // Informs the user that they are going to carry on to the general mental health questions
            System.out.println("\n** The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject. **");
            generalMentalHealthAssessment();
            
        }

    }


    // Anxiety Function to with specific questions related to the condition
    public static void anxietyAssessment(){
        // Sets Variables necessary for Anxiety Function
        String [] anxietyResources = readFile("Anxiety.txt"); // Holds the resources for anxiety from txt file in a String array
        int count = 0;


        // Asks user about specific questions related to Anxiety
        System.out.println("\nThe following questions are used to assess a persons standing with anxiety. This is NOT an official diagnosis; your result does not necessarily mean you are struggling with depression and each question might not even end up applying to you. However, thinking about these questions can help you understand the behaviors that are associated with anxiety. Please answer each question with a 0 (Not at all), 1 (Several Days), 2 (More than half the days), or 3 (Nearly every day).");
        System.out.print("1. Feeling nervous, anxious, or on edge: ");
        count += Integer.parseInt(System.console().readLine());
        System.out.print("\n2. Not being able to stop or control worrying: ");
        count += Integer.parseInt(System.console().readLine());
        System.out.print("\n3. Worrying too much about different things: ");
        count += Integer.parseInt(System.console().readLine());
        System.out.print("\n4. Trouble relaxing: ");
        count += Integer.parseInt(System.console().readLine());
        System.out.print("\n5. Being so restless that it is hard to sit still: ");
        count += Integer.parseInt(System.console().readLine());
        System.out.print("\n6. Becoming easily annoyed or irritable: ");
        count += Integer.parseInt(System.console().readLine());
        System.out.print("\n7. Feeling afraid as if something awful might happen: ");
        count += Integer.parseInt(System.console().readLine());

        if(count <= 4){
            System.out.println("Considering your responses, if we were to categorize the severity of Anxiety you may be experiencing, it would be considered minimal. Would you like to see some resources that could help you maintain good mental health and potentially prevent further anxiety? (Y/N):");
            String response = System.console().readLine();

            if(response.equals("Y") || response.equals("y") || response.equals("Y ") || response.equals("y ")){
                resourcesPrint(anxietyResources); // Prints out resources for anxiety

            } else if (response.equals("N") || response.equals("n") || response.equals("N ") || response.equals("n ")){
                System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                generalMentalHealthAssessment();

            } else {
                System.out.println("Invalid Input. Please enter Y or N.");
                String response2 = System.console().readLine();

                if(response2.equals("Y") || response2.equals("y") || response2.equals("Y ") || response2.equals("y ")){
                    resourcesPrint(anxietyResources); // Prints out resources for anxiety

                } else if (response2.equals("N") || response2.equals("n") || response2.equals("N ") || response2.equals("n ")){
                    System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                    generalMentalHealthAssessment();

                }
            }

        } else if (count <= 9){
            System.out.println("Considering your responses, if we were to categorize the severity of Anxiety you may be experiencing, it would be considered mild. Would you like to see some resources that could help you maintain good mental health and potentially prevent further anxiety? (Y/N):");
            String response = System.console().readLine();

            if(response.equals("Y") || response.equals("y") || response.equals("Y ") || response.equals("y ")){
                resourcesPrint(anxietyResources); // Prints out resources for anxiety

            } else if (response.equals("N") || response.equals("n") || response.equals("N ") || response.equals("n ")){
                System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                generalMentalHealthAssessment();

            } else {
                System.out.println("Invalid Input. Please enter Y or N.");
                String response2 = System.console().readLine();

                if(response2.equals("Y") || response2.equals("y") || response2.equals("Y ") || response2.equals("y ")){
                    resourcesPrint(anxietyResources); // Prints out resources for anxiety

                } else if (response2.equals("N") || response2.equals("n") || response2.equals("N ") || response2.equals("n ")){
                    System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                    generalMentalHealthAssessment();

                }
            }

        } else if (count <= 14){
            System.out.println("Considering your responses, if we were to categorize the severity of Anxiety you may be experiencing, it would be considered moderate. Would you like to see some resources that could help you maintain good mental health and potentially prevent further anxiety? (Y/N):");
            String response = System.console().readLine();
            
            if(response.equals("Y") || response.equals("y") || response.equals("Y ") || response.equals("y ")){
                resourcesPrint(anxietyResources); // Prints out resources for anxiety

            } else if (response.equals("N") || response.equals("n") || response.equals("N ") || response.equals("n ")){
                System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                generalMentalHealthAssessment();

            } else {
                System.out.println("Invalid Input. Please enter Y or N.");
                String response2 = System.console().readLine();

                if(response2.equals("Y") || response2.equals("y") || response2.equals("Y ") || response2.equals("y ")){
                    resourcesPrint(anxietyResources); // Prints out resources for anxiety

                } else if (response2.equals("N") || response2.equals("n") || response2.equals("N ") || response2.equals("n ")){
                    System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
                    generalMentalHealthAssessment();

                }
            }
        } else {
            System.out.println("\nConsidering your responses, if we were to categorize the severity of Anxiety you may be experiencing, it would be considered severe. The following links are crisis helplines that could help you in your time of need. (Provided by Mental Health America)");
            System.out.print("1. 988 Suicide & Crisis Lifeline: Call or text 988 or chat 988lifeline.org for immediate support | Operates 24/7\n2. Disaster Distress Helpline: Call or text 1-800-985-5990 to connect with a trained counselor 24/7\n3. The Trevor Project: Call 1-866-488-7386 or text START to 678678 for a 24/7 confidential suicide hotline for LGBTQIA2S+ youth\n4. National Domestic Violence Hotline: Call 1-800-799-7233 or log onto thehotline.org or text LOVEIS to 22522");        } 
    }

    // PTSD Function to with specific questions related to the condition
    public static void ptsdInfo(){
        // Sets variables necessary for the PTSD function
        String[] ptsdResources = readFile("Ptsd.txt");

        // General information about PTSD
        System.out.println("\nPTSD is a complex disorder that usually develops as the result of a traumatic event like:\n- A serious accident or fire\n- Assault or abuse\n- Earthquare or flood\n- A war\n- Seeing/experiencing a serious injury\n...and so much more (Provided by National Institute of Mental Health)\n");
        System.out.println("Common Symptoms include (Provided by NIMH):\n1. Flashbacks\n2. Nightmares\n3. Avoidance\n4. Reactivity/Hypervigilance\n5. Changes in cognition and mood");

        System.out.println("Would you be interested in looking into other resources about OCD? (Y/N)");
        String response = System.console().readLine();

        // If the user wants to see resources, then they will be prompted to enter the amount of resources they would like to see
        if(response.equals("Y") || response.equals("y") || response.equals("Y ") || response.equals("y ")){
            resourcesPrint(ptsdResources);

        } else {
            System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
            generalMentalHealthAssessment();

        }
    }   

    // OCD Function to with specific questions related to the condition
    public static void ocdAssessment(){
        // Sets variables necessary for the OCD function
        String [] ocdResources = readFile("Ocd.txt"); // Holds the resources for OCD from txt file in a String array


        // General information about OCD
        System.out.println("\nOCD is a complex and oten debilitating disorder that affects all ages and is most distinguisable by the dramatric cycle of obsessions and compulsions the person who suffers from the disorder becomes stuck in. (Provided by International OCD Foundation)\n");
        System.out.println("Common Symptoms include (Provided by IOCDF):\n1. Obsessions: unwanted, intrustive urges, thoughts, and images\n2. Compulsions: behaviors an individual does to get rid of obsessions and alleviate distress caused by them.");

        System.out.println("Would you be interested in looking into other resources about OCD? (Y/N)");
        String response = System.console().readLine();

        if(response.equals("Y") || response.equals("y") || response.equals("Y ") || response.equals("y ")){
            resourcesPrint(ocdResources); // Prints out resources for OCD

        } else {
            System.out.println("Thats okay! The following questions you are going to be asked are general wrap up questions that can help you maintain good mental health/know what it is regardless of your current status with the subject.");
            generalMentalHealthAssessment();

        }

    }



    // Functions that prints out all values in a String array
    public static void resourcesPrint(String[] r){
        for(int i = 0; i <= r.length; i++){
            System.out.println(r[i]);
        }
    }

    // Function that reads resources file and returns the contents as a String array
    public static String[] readFile(String filePath){
        ArrayList<String> resources = new ArrayList<String>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String resource;
            while((resource = br.readLine()) != null){
                resources.add(resource);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return resources.toArray(new String[0]);
    }
}