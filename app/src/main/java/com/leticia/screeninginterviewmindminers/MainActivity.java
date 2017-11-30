package com.leticia.screeninginterviewmindminers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtLargestNumberInTheTree = findViewById(R.id.txt_largest_number_tree);

        Tree tree = new Tree();
        Node node = new Node(20, new Node(8, new Node(4, null, null),
                new Node(12, null, null)), new Node(22, null, null));
        tree.setRoot(node);

        int largestNumber = searchNumberThLargestElementInTheTree(2, tree.getRoot());
        txtLargestNumberInTheTree.setText(String.format(Locale.getDefault(),
                "%s%d", getString(R.string.largest_number), largestNumber));
    }

    public int searchNumberThLargestElementInTheTree(int number, Node node) {

        if (node != null && count > -1) {
            number = searchNumberThLargestElementInTheTree(number, node.getRight());
            if (count > -1) {
                count++;
                if (count == number) {
                    count = -1;
                    return node.getValue();
                }
                number = searchNumberThLargestElementInTheTree(number, node.getLeft());
            }
        }

        return number;
    }
}
