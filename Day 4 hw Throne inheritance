class ThroneInheritance {

    private String king;
    private Map<String, List<String>> family;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        family = new HashMap<>();
        dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        family.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String person, List<String> order) {

        if (!dead.contains(person))
            order.add(person);

        if (!family.containsKey(person))
            return;

        for (String child : family.get(person))
            dfs(child, order);
    }
}
