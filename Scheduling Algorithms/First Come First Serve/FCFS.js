function fcfs(processes) {
  // Sort processes by Arrival Time
  processes.sort((a, b) => a.arrivalTime - b.arrivalTime);

  let currentTime = 0;
  let totalWaitingTime = 0;
  let totalTurnaroundTime = 0;

  processes.forEach(process => {
      if (currentTime < process.arrivalTime) {
          currentTime = process.arrivalTime; // Adjust for idle CPU time
      }

      process.startTime = currentTime;
      process.completionTime = currentTime + process.burstTime;
      process.turnaroundTime = process.completionTime - process.arrivalTime;
      process.waitingTime = process.turnaroundTime - process.burstTime;

      currentTime = process.completionTime; // Update current time
      totalWaitingTime += process.waitingTime;
      totalTurnaroundTime += process.turnaroundTime;
  });

  console.log("Processes:", processes);
  console.log("Average Waiting Time:", totalWaitingTime / processes.length);
  console.log("Average Turnaround Time:", totalTurnaroundTime / processes.length);
}

// Example Usage
const processesFCFS = [
  { id: "P1", arrivalTime: 0, burstTime: 4 },
  { id: "P2", arrivalTime: 1, burstTime: 3 },
  { id: "P3", arrivalTime: 2, burstTime: 1 }
];

fcfs(processesFCFS);
