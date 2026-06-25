import java.util.*;

class Item {
    int itemCode;
    String itemTitle;
    String itemType;

    Item(int itemCode, String itemTitle, String itemType) {
        this.itemCode = itemCode;
        this.itemTitle = itemTitle;
        this.itemType = itemType;
    }

    void showItem() {
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemTitle);
        System.out.println("Item Category : " + itemType);
    }
}

public class ProductFinder {

    static Item searchLinearly(Item[] itemList, int wantedCode) {
        for (Item currentItem : itemList) {
            if (currentItem.itemCode == wantedCode) {
                return currentItem;
            }
        }
        return null;
    }

    static Item searchBinary(Item[] itemList, int wantedCode) {
        int startIndex = 0;
        int endIndex = itemList.length - 1;

        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (itemList[middleIndex].itemCode == wantedCode) {
                return itemList[middleIndex];
            }

            if (itemList[middleIndex].itemCode < wantedCode) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        System.out.println("E-Commerce Product Search");
        System.out.print("Enter number of items: ");
        int totalItems = inputReader.nextInt();
        inputReader.nextLine();

        Item[] itemArray = new Item[totalItems];

        for (int counter = 0; counter < totalItems; counter++) {
            System.out.println("\nItem " + (counter + 1));

            System.out.print("Enter Item Code: ");
            int codeInput = inputReader.nextInt();
            inputReader.nextLine();

            System.out.print("Enter Item Name: ");
            String nameInput = inputReader.nextLine();

            System.out.print("Enter Item Category: ");
            String categoryInput = inputReader.nextLine();

            itemArray[counter] = new Item(codeInput, nameInput, categoryInput);
        }

        System.out.print("\nEnter Item Code to Search: ");
        int codeToFind = inputReader.nextInt();

        Item resultLinear = searchLinearly(itemArray, codeToFind);
        System.out.println("\nLinear Search Result:");
        if (resultLinear != null) {
            resultLinear.showItem();
        } else {
            System.out.println("Item not found.");
        }

        Item[] sortedItemArray = Arrays.copyOf(itemArray, itemArray.length);
        Arrays.sort(sortedItemArray, Comparator.comparingInt(obj -> obj.itemCode));

        Item resultBinary = searchBinary(sortedItemArray, codeToFind);
        System.out.println("\nBinary Search Result:");
        if (resultBinary != null) {
            resultBinary.showItem();
        } else {
            System.out.println("Item not found.");
        }

        inputReader.close();
    }
}