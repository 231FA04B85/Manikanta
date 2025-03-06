#include <stdio.h>

int knapsack(int val[], int wt[], int n, int W) {
    int c[n + 1][W + 1]; 
    int w;
    for ( w = 0; w <= W; w++)
        c[0][w] = 0;
        int i;
    for ( i = 0; i <= n; i++)
        c[i][0] = 0;
    for (i = 1; i <= n; i++) {
        for ( w = 1; w <= W; w++) {
            if (wt[i - 1] <= w) { 
                if (val[i - 1] + c[i - 1][w - wt[i - 1]] > c[i - 1][w])
                    c[i][w] = val[i - 1] + c[i - 1][w - wt[i - 1]];
                else
                    c[i][w] = c[i - 1][w];
            } else {
                c[i][w] = c[i - 1][w];
            }
        }
    }

    return c[n][W];
}

int main() {
    int n, W;

    printf("Enter the number of items: ");
    scanf("%d", &n);

    int val[n], wt[n];

    printf("Enter the values and weights of the items:\n");
    int i;
    for ( i = 0; i < n; i++) {
        printf("Item %d value: ", i + 1);
        scanf("%d", &val[i]);
        printf("Item %d weight: ", i + 1);
        scanf("%d", &wt[i]);
    }

    printf("Enter the maximum knapsack capacity: ");
    scanf("%d", &W);

    printf("Maximum value in Knapsack = %d\n", knapsack(val, wt, n, W));

    return 0;
}
