// C program to sequence n-jobs through two machines
#include<stdio.h>
int no_of_jobs;
int process_times[200][2];
int Q[200][2];
void read_job_configuration()
{
    int i;
    printf("Enter the no. of jobs:");
    scanf("%d",&no_of_jobs);
    printf("Enter th eprocessing times:");
    printf("Job\t mk1 \t mk2\t");
    printf("--------------------\n");
    for(i=0;i<no_of_jobs;i++ )
    {
        printf("%d\n",i+1);
        scanf("%d%d",&process_times[i][0],&process_times[i][1]);
    }
}
int find_smallest_point(marked)
int marked[200];
{
    int i,j;
    int small_2;
    int small_1 =small_2 = 999;
    int Job1,Job2;
    for(i=0;i<no_of_jobs;i++)
    if(!marked[i])
    {
        if(process_times[i][0] < small_1)
        {
            small_1 = process_times[i][0];
            Job1 = i;
            {
                if(process_times[i][1] < small_2)
                {
                    small_2 = process_times[i][1];
                    Job2 =i;
                }
            }
            if(small_1< small_2)
            return Job1;
            else
            if(small_2<small_1)
            return Job2;
            if(small_1 == small_2)
            if(process_times[Job1][1] < process_times[Job2][10])
            return Job1;
            else
            return Job2;
        }
    }

}

void find_sequence(sequence)
int sequence[200];
{
    int i,j,k;
    int Job;
    int marked[200],front,rear,job;
    front =0;
    rear = no_of_jobs - 1;
    for(i=0;i<no_of_jobs;i++)
    marked[i]=0;
    for(i=0;i<no_of_jobs;i++)
    {
        Job = find_smallest_point(marked);
        marked[Job] = 1;
        if(process_times[Job][0] <= process_times[job][1])
        sequence[front++] = job;
        else
        sequence[rear--] = job;


    }
    return;
}
void print_sequence(sequence)
int sequence[200];
{
    int i;
    printf("Optional sequence:");
    for(i=0;i<no_of_jobs;i++)
    printf("%d",sequence[i]+1);
    printf("\n");
}
void main()
{
    int sequence[200];
    printf("Sequence n jobs through 2 machine \n");
    read_job_configuration();
    find_sequence(sequence);
    print_sequence(sequence);
}




